package com.itbank.asynctask03;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        result = (TextView)findViewById(R.id.result);
    }

    public void getMnetChart(View view){
        ChartLoader loader = new ChartLoader();
        loader.execute();
    }

    //준비물 없음(Void), 진행상황 갱신(Integer), 결과물(String)
    private class ChartLoader extends AsyncTask<Void, Integer, String>{
        String url;
        @Override
        protected void onPreExecute() {
            url = "http://www.mnet.com/chart/top100/";
        }
        @Override
        protected String doInBackground(Void... voids) {
            StringBuffer buffer = new StringBuffer();
            try{
                //[1] 연결 주소 객체 생성
                //[2] 연결 수립
                //[3] 연결 환경설정
                //[4] 응답코드 확인
                //[5] 응답내용 읽기
                //[6] 연결 종료

                URL page = new URL(url);

                HttpURLConnection connection = (HttpURLConnection)page.openConnection();

                connection.setRequestMethod("GET");

                int resCode = connection.getResponseCode();
                if(resCode != HttpURLConnection.HTTP_OK)
                    throw new Exception("정상 응답이 아닙니다");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while(true){
                    String line = reader.readLine();
                    if(line == null) break;//입력 종료
                    buffer.append(line+"\n");
                }

                reader.close();
                connection.disconnect();
            }catch(Exception e){
                e.printStackTrace();
            }

            //이미 불러온 페이지(buffer)에 담긴 내용을 편집해야 한다(노래제목만 추출)
            String result = buffer.toString();
            buffer = new StringBuffer();

            //검색 시간을 구하여 출력
            String time = new SimpleDateFormat("yyyy-MM-dd a h:mm:ss").format(new Date());
            buffer.append(time+"\n");

            //Pattern과 Matcher 클래스를 이용하여 특정 영역을 탐색
            String regex = "<a href=\"\\/track\\/.*?\".*?>(.*?) - 곡정보<\\/a>";
            Matcher m = Pattern.compile(regex).matcher(result);

            int rank = 1;
            while(m.find()){
                buffer.append("["+rank+"] "+m.group(1)+"\n");
                rank++;
            }

            return buffer.toString();
        }
        @Override
        protected void onPostExecute(String s) {
            result.setText(s);
        }
    }
}









