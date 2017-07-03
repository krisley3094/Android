package com.itbank.listview02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] chart = new String[]{
            "눈물의 온도","무제","SIGNAL","개소리","NEVER","I LUV IT", "LONELY", "오늘 취하면", "New Face",
            "Shape of You", "팔레트", "SUPER STAR","맞지?","REALLY REALLY","BLUE MOON","Oh Little Girl",
            "미치고 싶다","INTRO. 권지용","처음부터 너와 나","사랑이 잘(With 오혁)", "CALLING YOU",
            "열어줘","밤편지","첫눈처럼 너에게 가겠다","Marry Me", "TOMBOY", "사랑앓이(With 김나영)",
            "KNOCK KNOCK","아름다워","OUTRO.신곡","좋다고 말해"
    };

    private CheckBox checkAll;
    private ListView chartView;
    private TextView playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAll = (CheckBox)findViewById(R.id.checkAll);
        chartView = (ListView)findViewById(R.id.chartView);
        playing = (TextView)findViewById(R.id.playing);

        //Adapter를 만들어서 chartView에 chart 추가
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_multiple_choice, chart);
        chartView.setAdapter(adapter);

        chartView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String song = chart[i];
                playing.setText("선택된 곡 : "+song);
            }
        });
    }
}










