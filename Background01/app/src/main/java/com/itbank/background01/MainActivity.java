package com.itbank.background01;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new Receiver();
    }

    public void start1(View view){
        //0부터 100까지 1씩 증가시켜가면서 화면에 표시 (간격 = 0.1초)
        TextView result1 = (TextView)findViewById(R.id.result1);
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setEnabled(false);

        for(int i=0; i<=100; i++){
            result1.setText(String.valueOf(i));
            Log.d("start1", String.valueOf(i));

            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
        }

        btn1.setEnabled(true);
    }

    public void start2(View view){
        TextView result2 = (TextView)findViewById(R.id.result2);
        Button btn2 = (Button)findViewById(R.id.btn2);

        //btn2.setEnabled(false);
        //쓰레드를 생성하여 카운트 증가를 부탁
        Worker worker = new Worker();
        //일을 시킬 때에는 아래와 같이 지시
        worker.start();

        //btn2.setEnabled(true);
    }

    //추가 일꾼 클래스 정의
    private class Worker extends Thread{
        //일꾼이 작업할 내용은 run()에 정의한다
        @Override
        public void run() {
            TextView result2 = (TextView)findViewById(R.id.result2);
            for(int i=0; i<=100; i++){
                //result2.setText(String.valueOf(i));//에러 : 월권 행위(UI 스레드가 아닌데 UI를 제어하려고 시도)

                //직접 제어가 불가능하므로 receiver에게 전달
                Message msg = new Message();    //[1] 전달할 메세지 생성
                msg.arg1 = i;                                //[2] 데이터 설정
                receiver.sendMessage(msg);        //[3] receiver에게 데이터 전송

                Log.d("start2", String.valueOf(i));
                try{
                    Thread.sleep(100);
                }catch(Exception e){}
            }
        }
    }

    //수신기 정의
    private class Receiver extends Handler{
        @Override
        public void handleMessage(Message msg) {
            //메세지가 외부에서 수신되었을 때 실행될 기능
            //수신된 메세지는 msg라는 형태의 객체로 저장
            TextView result2 = (TextView)findViewById(R.id.result2);
            result2.setText(String.valueOf(msg.arg1));
        }
    }
}
