package com.itbank.screen05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //activity_main.xml에 등록된 대상의 정보를 불러와서 사용
        TextView resultView = (TextView)findViewById(R.id.result);

        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<20000; i++)
            buffer.append("스크롤뷰 공부중 "+(i+1)+"\n");
        resultView.setText(buffer.toString());

//        20000만줄짜리 문장 생성
//        String text = "";
//        for(int i=0; i<20000; i++)
//            text += "스크롤뷰 공부중 "+(i+1) +"\n";
//        resultView.setText(text);
    }
}











