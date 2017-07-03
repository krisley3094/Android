package com.itbank.dialog01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //원래 뒤로가기 버튼을 누르면... 액티비티 종료
    // - 이것을 원치 않는 경우는 뒤로 가기 버튼을 누르면 처리할 일을 재정의

    private long before = 0L;
    @Override
    public void onBackPressed() {
        //super.onBackPressed();//원래 하던 일
        //System.currentTimeMillis()를 이용하여 시차를 측정

        long current = System.currentTimeMillis();

        if(current - before < 2000L){
            finish();//액티비티 종료
        }else{
            Toast.makeText(getApplicationContext(), "한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show();
            before = current;
        }
    }
}
