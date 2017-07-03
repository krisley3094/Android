package com.itbank.activity04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] title = new String[]{
            "남이 될 수 있을까",
            "무제(無題) (Untitled, 2014)",
            "SIGNAL",
            "New Face",
            "I LUV IT",
            "NEVER",
            "Shape of You",
            "REALLY REALLY",
            "팔레트(Feat. G-DRAGON)",
            "오늘 취하면(Feat. 창모)",
            "맞지?",
            "첫눈처럼 너에게 가겠다",
            "처음부터 너와 나",
            "사랑이 잘(With 오혁)",
            "KNOCK KNOCK",
            "LONELY",
            "Marry Me",
            "Oh Little Girl",
            "SUPER STAR",
            "좋다고 말해",
            "오빠야",
            "BLUE MOON",
            "밤편지",
            "미치고 싶다",
            "열어줘",
            "우주를 줄게",
            "SWEET MELODY",
            "TOMBOY",
            "불장난",
            "나만 안되는 연애",
            "All I Wanna Do (K)",
            "Why Don`t You Know(Feat. 넉살)",
            "너였다면",
            "TT",
            "사랑앓이(With 김나영)",
            "MAGIC CARPET",
            "여보세요",
            "Beautiful",
            "얼굴 찌푸리지 말아요",
            "오랜 날 오랜 밤",
            "개소리 (BULLSHIT)",
            "아프지 마요",
            "Closer(Feat. Halsey)",
            "아름다워",
            "Decalcomanie (데칼코마니)",
            "그대라는 사치",
            "심술",
            "BOMB(Feat. B.I, BOBBY)",
            "지나쳐(Feat. DEAN)",
            "Rookie"
    };
    private ListView chart;
    private ArrayAdapter<String> adapter;

    //보내기 위한 ArrayList
    private ArrayList<String> sendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendList = new ArrayList<>();

        chart = (ListView)findViewById(R.id.chart);
        adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_multiple_choice, title);
        chart.setAdapter(adapter);

//        [방법1] 체크할 때마다 일일이 sendList에 데이터를 추가/삭제 하는 방법
//         - 단점 : 매우 귀찮다.. 오류가 날 가능성 존재
//        chart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //Toast.makeText(getApplicationContext(), "i = "+i, Toast.LENGTH_SHORT).show();
//                String song = (String)chart.getItemAtPosition(i);
//                if(sendList.contains(song)){
//                    sendList.remove(song);
//                }
//                else{
//                    sendList.add(song);
//                }
//            }
//        });
    }

    public void moveActivity(View view){
//        [방법2] 보내기 직전에 체크된 항목들을 전부다 sendList에 등록

        /* ListView에서 체크된 항목만 찾아보는 코드 */
        sendList.clear();
        int size = chart.getCount();    //아이템 개수
        for(int i=0; i<size; i++){
            if(chart.isItemChecked(i)){ //체크 여부 확인
                sendList.add(chart.getItemAtPosition(i).toString());
            }
        }
        /* ListView에서 체크된 항목만 찾아보는 코드 */

        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
        intent.putExtra("playlist", sendList);
        startActivity(intent);
    }
}
