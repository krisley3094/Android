package com.itbank.activity02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveActivity(View view){
        int id = view.getId();

        if(id == R.id.move1){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.move3) {
            //이미 열려있다면 새로 생성하지 않기로 하고 이동....
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//최상층의 내용은 재실행하지 않음
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//이전에 실행했던 이력이 있으면 돌아감
            startActivity(intent);
        }
        else if(id == R.id.move2){
            //Intent를 만들어 페이지 이동을 지시
            //Intent intent = new Intent(어디서, 어디로);
            Intent intent = new Intent(MainActivity.this, ManualActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.move4){
            Intent intent = new Intent(MainActivity.this, AutoActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.move5){
            //Intent에 데이터를 첨부하여 전송
            Intent intent = new Intent(MainActivity.this, DataActivity.class);
            //intent.putExtra("이름", 값);
            intent.putExtra("a", 100);
            intent.putExtra("b", true);
            intent.putExtra("c", 1.5);
            intent.putExtra("d", "hello");
            startActivity(intent);
        }
        else if(id == R.id.move6){
            Intent intent = new Intent(MainActivity.this, DataActivity.class);
            startActivity(intent);
        }
    }
}







