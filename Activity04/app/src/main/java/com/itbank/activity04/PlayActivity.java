package com.itbank.activity04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //데이터 꺼내고 ListView에 Adapter형식으로 데이터 설정
        Intent receive = getIntent();
        ArrayList<String> data = receive.getStringArrayListExtra("playlist");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                PlayActivity.this, R.layout.support_simple_spinner_dropdown_item, data);

        ListView playlist = (ListView)findViewById(R.id.playlist);
        playlist.setAdapter(adapter);
    }

    public void goBack(View view){
        finish();
    }
}









