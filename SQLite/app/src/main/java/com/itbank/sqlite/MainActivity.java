package com.itbank.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //DB의 관리를 도와주는 Helper의 객체를 생성
    private DBHelper helper;

    private EditText name;
    private EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        price = (EditText)findViewById(R.id.price);

        helper = new DBHelper(getApplicationContext(), "cafe.db", null, 3);
    }

    public void insert(View view){
        //입력창 2군데에 작성된 데이터를 가져와서 helper에게 전달하며 등록하도록 지시
        String menu = name.getText().toString();
        int menuprice = Integer.parseInt(price.getText().toString());

        helper.insert(menu, menuprice);
    }

    public void select(View view){
        String data = helper.getList();
        //TextView에 출력
        TextView result = (TextView)findViewById(R.id.result);
        result.setText(data);
    }

    public void delete(View view){
        //이름만 있으면 삭제 가능
        String menu = name.getText().toString();
        helper.delete(menu);
    }

    public void update(View view){
        //변경할 대상의 이름과 변경할 가격 정보가 필요
        String m = name.getText().toString();
        int p = Integer.parseInt(price.getText().toString());
        helper.update(m, p);
    }
}









