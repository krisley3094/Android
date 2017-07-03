package com.itbank.activity05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;

public class OtpActivity extends AppCompatActivity {

    private TextView imsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        imsi = (TextView)findViewById(R.id.imsi);
    }

    public void generate(View view){
        //4자리 OTP 번호 생성
        int otp = (int)(Math.random() * 10000);//0 ~ 9999
        Format f = new DecimalFormat("0000");
        String res = f.format(otp);
        imsi.setText(res);
    }

    public void useOtp(View view){
        //나를 불러낸 Activity 에 intent를 만들어 전달해주면 된다
        Intent intent = new Intent();//목적지가 이미 정해져 있음
        intent.putExtra("otp", imsi.getText().toString());//데이터 설정
        setResult(200, intent);//결과 설정
        finish();
    }
}












