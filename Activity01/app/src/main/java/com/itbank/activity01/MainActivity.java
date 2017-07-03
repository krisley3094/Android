package com.itbank.activity01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private void append(String text){
        result.append(text+"\n");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.result);
        append("onCreate() 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();
        append("onStart() 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        append("onStop() 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        append("onDestroy() 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        append("onPause() 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        append("onResume() 호출");
    }
}
