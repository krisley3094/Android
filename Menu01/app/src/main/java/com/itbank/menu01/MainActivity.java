package com.itbank.menu01;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //액션바(메뉴)에 대한 추가 설정들을 구현
        ActionBar bar = MainActivity.this.getSupportActionBar();

        bar.setTitle("hello");
        bar.setBackgroundDrawable(new ColorDrawable(0xFF339999));
        bar.setDisplayHomeAsUpEnabled(true);//홈버튼 표시여부
    }

    //메뉴를 보여주기 위해 재정의해야할 메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu.xml을 inflate 처리
        MainActivity.this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //메뉴에서 발생하는 이벤트를 처리하기 위해 재정의해야할 메소드

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            //홈버튼은 자동으로 부여된 아이디를 사용
            case android.R.id.home:
                Toast.makeText(getApplicationContext(), "home버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search://검색
                Toast.makeText(getApplicationContext(), "search버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_camera://사진
                Toast.makeText(getApplicationContext(), "camera버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_info://정보
                Toast.makeText(getApplicationContext(), "info버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_setting://설정
                Toast.makeText(getApplicationContext(), "setting버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}











