package com.itbank.asynctask02;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBackground(View view){
        Button btn = (Button)findViewById(R.id.btn);
        btn.setEnabled(false);

        //백그라운드 작업 시작
        BackgroundTask task = new BackgroundTask();
        task.execute();
    }

    //백그라운드 작업을 수행할 클래스 구현
    private class BackgroundTask extends AsyncTask<Void, Void, String>{
        String url;
        @Override
        protected void onPreExecute() {//ui 접근 가능
            url = "http://sysout.co.kr";
        }
        @Override
        protected String doInBackground(Void... voids) {//ui 접근 불가
            StringBuffer buffer = new StringBuffer();

            try{
                //HTTP 요청(홈페이지를 불러오겠다... 물론 코드를...)

                //[1] 목표 페이지 설정
                URL page = new URL(url);

                //[2] 연결 시도(접속)
                HttpURLConnection connection = (HttpURLConnection)page.openConnection();

                //[3] 접속 환경 설정
                connection.setConnectTimeout(10000);        //접속 대기 시간의 상한선을 설정
                connection.setRequestMethod("GET");         //접속 방식(요청 방식 : GET/POST)
                connection.setUseCaches(true);                  //캐시 사용여부
                connection.setDoInput(true);
                connection.setDoOutput(true);

                //[4] 응답 코드를 수신 (정상 : 200 , 바꿔치기 : 304 , 없음 : 404 , 오류 : 500)
                int resCode = connection.getResponseCode();
                if(resCode != HttpURLConnection.HTTP_OK
                           && resCode != HttpURLConnection.HTTP_NOT_MODIFIED)
                    throw new Exception("잘못된 응답 코드");

                //[5] 응답코드가 200일 경우는 페이지의 내용을 읽어서 버퍼에 추가.....
                //[5-1] 읽어들이는 도구 생성(reader)
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                                                                                    connection.getInputStream()));
                //[5-2] 신나게 읽어들여서 buffer에 추가
                while(true){
                    String line = reader.readLine();
                    if(line == null) break;
                    buffer.append(line+"\n");
                }

                //[5-3] 사용한 자원 회수
                reader.close();

                //[6] 연결 종료
                connection.disconnect();
            }catch(Exception e){
                e.printStackTrace();
            }

            return buffer.toString();
        }
        @Override
        protected void onPostExecute(String s) {//ui 접근 가능
            TextView result = (TextView)findViewById(R.id.result);
            result.setText(s);
            Button btn = (Button)findViewById(R.id.btn);
            btn.setEnabled(true);
        }
    }
}

















