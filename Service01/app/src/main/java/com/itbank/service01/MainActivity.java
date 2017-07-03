package com.itbank.service01;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //재생 도구
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playMusic(View view){
        if(player == null) {
            player = MediaPlayer.create(MainActivity.this, R.raw.palette);
            player.start();
        }
    }

    public void stopMusic(View view){
        if(player != null && player.isPlaying()){
            player.stop();
            player = null;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
