package com.itbank.listview03;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //필요한 준비 요소들....(1) ListView의 참조 , (2) ListAdapter의 객체
    private ListView myList;
    private ListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = (ListView)findViewById(R.id.mylist);
        myAdapter = new ListAdapter();
        myList.setAdapter(myAdapter);

        loadData();
    }

    //myAdapter에 데이터를 설정하는 기능
    private void loadData(){
        //myAdapter.add(new ListItem(이미지, 제목, 내용, 가격));
        Drawable icon;

        icon = getDrawable(R.drawable.angularjs);
        myAdapter.add(new ListItem(icon, "AngularJS", "요즘 핫한 SPA 스크립트", 650000));

        icon = getDrawable(R.drawable.c);
        myAdapter.add(new ListItem(icon, "C언어", "가장 오래 살아남은 클래식 언어", 200000));

        icon = getDrawable(R.drawable.centos);
        myAdapter.add(new ListItem(icon, "CentOS", "리눅스계의 하이브리드 OS", 450000));

        for(int i=0; i<100; i++) {
            icon = getDrawable(R.drawable.hadoop);
            myAdapter.add(new ListItem(icon, "하둡 프로그래밍", "자바 빅데이터 분산 처리 시스템", 800000));
        }

    }
}
