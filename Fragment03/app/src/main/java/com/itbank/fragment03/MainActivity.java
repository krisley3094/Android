package com.itbank.fragment03;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FirstFragment를 attach 처리
        //[1] Fragment를 생성
        FirstFragment fragment = new FirstFragment();
        //[2] 넘겨줄 데이터 묶음을 생성
        Bundle bundle = new Bundle();
        bundle.putString("a", "hello");
        fragment.setArguments(bundle);//fragment에 데이터 전달 효과

        //[3] 배치 도구를 구해와서 배치 처리
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.add(어디에, 무엇을);
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }

    public void changeFragment(View view){
        //누른 버튼에 따라서 다른 형태의 Fragment를 생성하여 배치 처리
        if(view.getId() == R.id.firstBtn){
            FirstFragment fragment = new FirstFragment();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);//fragment에 데이터 전달 효과

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }
        else if(view.getId() == R.id.secondBtn){
            SecondFragment fragment = new SecondFragment();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);//fragment에 데이터 전달 효과

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }
    }
}










