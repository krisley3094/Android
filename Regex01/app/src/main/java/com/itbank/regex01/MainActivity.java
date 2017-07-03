package com.itbank.regex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void phoneCheck(View view){
        //휴대전화번호 형식에 맞는지 검사하여 Toast로 출력
        EditText phone = (EditText)findViewById(R.id.phone);
        String input = phone.getText().toString();

        String regex = "^010(-[0-9]{4}){2}$";

        if(Pattern.matches(regex, input)){
            Toast.makeText(getApplicationContext(), "올바른 휴대전화 번호입니다", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "잘못된 휴대전화 번호입니다", Toast.LENGTH_SHORT).show();
        }
    }

    public void idCheck(View view){
        EditText member_id = (EditText)findViewById(R.id.member_id);
        String input = member_id.getText().toString();

        String regex = "^[a-zA-Z][a-zA-Z0-9]{7,19}$";

        if(Pattern.matches(regex, input)){
            Toast.makeText(getApplicationContext(), "올바른 아이디입니다", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "잘못된 아이디입니다", Toast.LENGTH_SHORT).show();
        }
    }

    public void birthCheck(View view){
        EditText birth = (EditText)findViewById(R.id.birth);
        String input = birth.getText().toString();

        String regex = "^(19|20)[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$";

        if(Pattern.matches(regex, input)){
            Toast.makeText(getApplicationContext(), "올바른 생년월일입니다", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "잘못된 생년월일입니다", Toast.LENGTH_SHORT).show();
        }
    }
}












