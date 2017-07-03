package com.itbank.activity02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        //전달된 데이터를 꺼내는 명령을 구현
        Intent receiveData = DataActivity.this.getIntent();
        int a = receiveData.getIntExtra("a", 0);
        boolean b = receiveData.getBooleanExtra("b", false);
        double c = receiveData.getDoubleExtra("c", 0.0);
        String d = receiveData.getStringExtra("d");//없으면 null

        String text = "a = "+a+"\n";
        text += "b = "+b+"\n";
        text += "c = "+c+"\n";
        text += "d = "+d+"\n";

        TextView result = (TextView)findViewById(R.id.result);
        result.setText(text);
    }
}
