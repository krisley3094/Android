package com.itbank.event04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //[1] id를 가지고 있는 컴포넌트를 사용할 수 있도록 불러온다
    //[2] onClick이 실행될 수 있도록 처리 메소드를 구현한다

    private EditText v1;
    private EditText v2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //아이디로 컴포넌트 불러오는 코드
        v1 = (EditText)findViewById(R.id.v1);
        v2 = (EditText)findViewById(R.id.v2);
        result = (TextView) findViewById(R.id.result);
    }

    //[1] v1과 v2에 작성된 숫자를 가져온다
    //[2] 두 숫자를 더하여 result에 설정한다
    public void plus(View view){
        try{
            int a = Integer.parseInt(v1.getText().toString());
            int b = Integer.parseInt(v2.getText().toString());

            result.setText(String.valueOf(a + b));
        }catch(Exception e){
            //처리 과정에서 문제가 발생한다면
            Toast.makeText(getApplicationContext(), "잘해라~", Toast.LENGTH_SHORT).show();
        }
    }
    public void minus(View view){
        try{
            int a = Integer.parseInt(v1.getText().toString());
            int b = Integer.parseInt(v2.getText().toString());

            result.setText(String.valueOf(a - b));
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "잘해라~", Toast.LENGTH_SHORT).show();
        }
    }

    //두 개 이상의 컴포넌트에서 동시에 onClick을 지정한 경우 이를 구별하여 사용할 수 있다.
    //매개변수 View 정보가 이를 가지고 있다
    public void erase(View view){
        switch(view.getId()){
            case R.id.e1:
                v1.setText("");
                break;
            case R.id.e2:
                v2.setText("");
                break;
        }
    }
}









