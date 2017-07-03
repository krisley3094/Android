package com.itbank.event01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);         //프로그램에 필요한 기본 준비를 수행하도록 지시
        setContentView(R.layout.activity_main);   //activity_main.xml을 불러와서 화면을 구성하도록 지시

        btn = (Button)findViewById(R.id.btn);
        //버튼을 눌렀을 때 벌어질 일을 설정만 해두겠다(이벤트 바인딩)
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //실제 클릭시 실행할 내용
                btn.setEnabled(false);//버튼 비활성화
            }
        });
    }
}
