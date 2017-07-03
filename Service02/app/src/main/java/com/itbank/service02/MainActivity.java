package com.itbank.service02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void startMusic(View view){
        //서비스 시작
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
    }
    public void stopMusic(View view){
        //서비스 종료
        Intent intent = new Intent(MainActivity.this, MyService.class);
        stopService(intent);
    }
}










