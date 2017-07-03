package com.itbank.activity03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveActivity(View view){
//        여러개의 데이터 묶음을 전달
//        List<String> list = new ArrayList<>();//전송 불가(직렬화가 안되어 있다)
        ArrayList<String> list = new ArrayList<>();//전송 가능(직렬화가 구현되어 있다)
        list.add("빨강");
        list.add("주황");
        list.add("노랑");
        list.add("초록");
        list.add("파랑");
        list.add("남색");
        list.add("보라");

        Intent intent = new Intent(MainActivity.this, DataActivity.class);

        intent.putExtra("list", list);

        startActivity(intent);
    }

    public void moveActivity2(View view){
        //Car의 객체를 만들어서 intent에 첨부
        Car c = new Car("람보르기니", 350);

        Intent intent = new Intent(MainActivity.this, ObjectActivity.class);
        intent.putExtra("car", c);//직렬화 구현된 객체만 전송 가능
        startActivity(intent);
    }
}












