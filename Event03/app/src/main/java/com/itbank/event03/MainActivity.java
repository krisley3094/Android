package com.itbank.event03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //activity_main에서 지정한 메소드를 만들어 주기만 하면 안드로이드가 자동으로 연결
    // - 지정된 형식에 맞게 만들어야 한다
    //      public void 이름(View view){}

    public void first(View view){
        //토스트 메세지
        //[1] 토스트 메세지의 출처 - 앱 정보
        //[2] 토스트 메세지의 내용 - String
        //[3] 토스트 메세지의 표시 시간 - Toast.LENGTH_SHORT(2초) 또는 Toast.LENGTH_LONG(4초)
        Toast.makeText(getApplicationContext(), "첫번째 버튼 눌렀음", Toast.LENGTH_SHORT).show();
        //로그 - Log      개발할 때의 값의 변화를 확인하기 위하여 사용
        //Log.d("이름", "메세지");
        Log.d("SHILHANG", "first 실행됨");
    }
    public void second(View view){
        Toast.makeText(getApplicationContext(), "두번째 버튼 눌렀음", Toast.LENGTH_LONG).show();
        Log.d("GEUNHYE", "Second 실행됨");
    }
}











