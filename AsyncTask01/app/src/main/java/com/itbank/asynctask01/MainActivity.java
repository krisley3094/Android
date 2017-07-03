package com.itbank.asynctask01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input1;
    private TextView result1;
    private EditText input2;
    private TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText)findViewById(R.id.input1);
        result1 = (TextView)findViewById(R.id.result1);
        input2 = (EditText)findViewById(R.id.input2);
        result2 = (TextView)findViewById(R.id.result2);
    }

    public void square(View view){
        //동기화 작업 : UI스레드가 계산까지 다 구현
        //(장점) 코드가 짧고 간편하다
        //(단점) 계산량이 많아지고 계산시간이 길어지면 화면갱신이 제때 이루어지지 않는다
        //int value = Integer.parseInt(input1.getText().toString());
        //result1.setText(String.valueOf(value * value));

        //비동기 작업 : AsyncTask<?, ?, ?> 클래스의 객체를 구현한 뒤 호출하여 처리
        int value = Integer.parseInt(input1.getText().toString());
        Process1 pro = new Process1();
        pro.execute(value);
    }

    //처리 클래스 생성
    private class Process1 extends AsyncTask<Integer, Void, Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(Integer integer) {
            result1.setText(integer.toString());
        }
        @Override
        protected Integer doInBackground(Integer... integers) {
            int value = integers[0];
            return value * value;
        }
    }

    public void factorial(View view){
        int value = Integer.parseInt(input2.getText().toString());
        Process2 pro = new Process2();
        pro.execute(value);
    }

    private class Process2 extends AsyncTask<Integer, Void, Integer>{
        @Override
        protected Integer doInBackground(Integer... integers) {
            int value = integers[0];
            int result = 1;
            for(int i=1; i<=value; i++){
                result *= i;
            }
            //result2.setText(String.valueOf(result));
            return result;
        }
        @Override
        protected void onPostExecute(Integer integer) {
            result2.setText(integer.toString());
        }
    }
}












