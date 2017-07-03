package com.itbank.listview04;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

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
    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = (ListView)findViewById(R.id.chart);
        adapter = new MusicAdapter();
        chart.setAdapter(adapter);

        //데이터 추가
        for(int i=0; i<title.length; i++){
            Drawable image = getDrawable(R.drawable.dummy);
            MusicData data = new MusicData(image, i+1, title[i]);
            adapter.add(data);
        }
    }
}
