package com.itbank.dynamic02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = (LinearLayout)findViewById(R.id.view1);
    }

    public void showQuiz1(View view){
        //view1에 quiz.xml을 만들어서 갖다 붙인다

        //레이아웃 합성은 LayoutInflater라는 클래스의 객체로 수행한다
        //시스템에 존재하는 것을 빌려와서 사용한다......... getSystemService()
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.quiz, view1, true);

        //inflater.inflate(1, 2, 3);
        //1(무엇을 : quiz.xml), 2(어디에 : view1), 3(어떻게 : true-추가, false-정보획득)
    }
}









