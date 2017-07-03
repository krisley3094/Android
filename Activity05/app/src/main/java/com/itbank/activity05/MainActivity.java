package com.itbank.activity05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.result);
    }

    public void getOtp(View view){
        Intent intent = new Intent(MainActivity.this, OtpActivity.class);
        //startActivity(intent);//단순한 이동
        //startActivityForResult(intent, 요청코드);
        startActivityForResult(intent, 9876);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        requestCode = 보낼때의 요청코드
//        resultCode = 처리 결과 코드(웹과 동일)
//        data = 돌아온 intent
        String otp = data.getStringExtra("otp");
        result.setText("전달된 OTP = "+otp);
    }
}














