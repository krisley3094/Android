package com.itbank.service03;

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

    public void startMusic(View view){
        //Service 실행
        Intent intent = new Intent(MainActivity.this, AudioService.class);
        startService(intent);
    }

    public void stopMusic(View view){
        //Service 종료
        Intent intent = new Intent(MainActivity.this, AudioService.class);
        stopService(intent);
    }
}
