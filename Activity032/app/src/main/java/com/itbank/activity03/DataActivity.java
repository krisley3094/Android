package com.itbank.activity03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        //넘어온 데이터를 받아주는 코드 구현
        Intent receive = getIntent();
        ArrayList<String> list = receive.getStringArrayListExtra("list");

        TextView result = (TextView)findViewById(R.id.result);
        result.setText(list.toString());
    }
}
