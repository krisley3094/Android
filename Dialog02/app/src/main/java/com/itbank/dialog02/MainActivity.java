package com.itbank.dialog02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private long before = 0L;

    @Override
    public void onBackPressed() {
        //AlertDialog라는 클래스를 이용하여 알림창을 띄워서 사용자에게 종료할것인지 묻겠다
        //AlertDialog dialog = new AlertDialog();

        //Builder 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        //builder에 AlertDialog의 속성을 설정
        builder.setTitle("종료 확인");
        builder.setMessage("프로그램을 종료하시겠습니까?");
        builder.setIcon(R.mipmap.ic_launcher);


        builder.setPositiveButton("끌거야!", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                long current = System.currentTimeMillis();
                if(current - before < 2000L){
                    Toast.makeText(getApplicationContext(), "Byebye", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "You Gotta Press Faster!", Toast.LENGTH_SHORT).show();
                    before = current;
                }

            }
        });

        builder.setNegativeButton("싫어!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();//창 닫기
            }
        });

        builder.setCancelable(false);//바깥쪽 클릭으로 창이 닫히지 않도록 설정

        //Builder를 이용하여 객체 생성
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
