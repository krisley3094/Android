package com.itbank.framelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //[1] 이미지 5개 불러오기
    //[2] 버튼의 이벤트 처리 메소드 구현

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;

    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //이미지뷰 불러와서 설정
        image1 = (ImageView)findViewById(R.id.image1);
        image2 = (ImageView)findViewById(R.id.image2);
        image3 = (ImageView)findViewById(R.id.image3);
        image4 = (ImageView)findViewById(R.id.image4);
        image5 = (ImageView)findViewById(R.id.image5);
        
    }

    // [이전]/[다음]을 누르면 실행될 처리 메소드
    public void change(View view){
        if(view.getId() == R.id.prev){
            index--;            //위치를 1 감소
            if(index < 1)     //맨 앞이라면
                index = 5;     //맨 뒤로 보내라
        }
        else{//view.getId() == R.id.next
            index ++;         //위치를 1 증가
            if(index > 5)     //마지막이라면
                index = 1;     //맨 앞으로 보내라
        }

        //로그를 이용하여 변수 값 확인
        Log.d("INDEX", String.valueOf(index));

        //index를 표시하는 처리
        image1.setVisibility(View.INVISIBLE);
        image2.setVisibility(View.INVISIBLE);
        image3.setVisibility(View.INVISIBLE);
        image4.setVisibility(View.INVISIBLE);
        image5.setVisibility(View.INVISIBLE);

        switch(index){
            case 1: image1.setVisibility(View.VISIBLE); break;
            case 2: image2.setVisibility(View.VISIBLE); break;
            case 3: image3.setVisibility(View.VISIBLE); break;
            case 4: image4.setVisibility(View.VISIBLE); break;
            case 5: image5.setVisibility(View.VISIBLE); break;
        }
    }
}











