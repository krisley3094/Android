package com.itbank.listview01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView result;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView에 데이터를 집어넣고 목록으로 구현
        result = (ListView)findViewById(R.id.result);

        //대규모 데이터를 저장하기 위해서는 (1) 배열 , (2) List 등을 이용할 수 있다
        list = new ArrayList<>();
        for(int i=1; i<=1000; i++){
            list.add("리스트뷰 항목 샘플 "+i+"번");
        }

        //ArrayAdapter를 이용하여 list를 result에 설정
        // 1 (어디에 : MainActivity에) , 2 (무엇을 : 기본 제공 형태중 한개를), 3 (데이터 : list에 있는 데이터)
        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, list);

        result.setAdapter(adapter);//result에 adapter 장착


        result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String text = "position = "+position+", id = "+id;
                list.remove(position);
                adapter.notifyDataSetChanged();//데이터 갱신 알림
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}












