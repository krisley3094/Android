package com.itbank.dynamic03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    //[1] 불러와야 할 것들     LinearLayout(id=dynamic)
    //[2] 처리할 이벤트 메소드   add(), removeAll()
    private LinearLayout list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (LinearLayout)findViewById(R.id.list);
    }

    public void add(View view){
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.input, list, true);

        //View tempView = inflater.inflate(R.layout.input, list, true);

        //이벤트 설정을 구현해야 한다.
        //EditText edit = (EditText)tempView.findViewById(????);
    }

    public void removeAll(View view){
        list.removeAllViews();
    }
}











