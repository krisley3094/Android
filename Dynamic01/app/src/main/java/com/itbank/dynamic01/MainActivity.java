package com.itbank.dynamic01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    //[1] 불러와야 할 구성요소                   LinearLayout(view1)
    //[2] 만들어야 할 이벤트 처리 메소드     showQuiz1()

    private LinearLayout view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = (LinearLayout) findViewById(R.id.view1);
    }

    public void showQuiz1(View view){
        view1.setVisibility(View.VISIBLE);
    }
}
