package com.itbank.event02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView starView;

    private Button minus10;
    private Button minus1;
    private Button plus1;
    private Button plus10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //앱 구동에 필요한 컴포넌트들을 전부다 불러온다
        starView = (TextView)findViewById(R.id.star);
        minus10 = (Button)findViewById(R.id.minus10);
        minus1 = (Button)findViewById(R.id.minus1);
        plus1 = (Button)findViewById(R.id.plus1);
        plus10 = (Button)findViewById(R.id.plus10);

        //plus1을 누르면 실행할 내용을 설정 - starView에 있는 숫자를 꺼내와서 1 더한 뒤에 재설정 한다
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(starView.getText().toString());
                starView.setText(String.valueOf(count + 1));
            }
        });

        plus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(starView.getText().toString());
                starView.setText(String.valueOf(count + 10));
            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(starView.getText().toString());
                if(count == 0) return;
                starView.setText(String.valueOf(count - 1));
            }
        });

        minus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(starView.getText().toString());
                if(count < 10) return;
                starView.setText(String.valueOf(count - 10));
            }
        });
    }
}










