package com.itbank.service02;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {

    private MediaPlayer player;

    public MyService() {
    }

    @Override
    public void onCreate() {
        //플레이어를 생성
        if(player == null){
            player = MediaPlayer.create(getApplicationContext(), R.raw.iluvit);
            player.setLooping(false);//반복 금지
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(player != null)
            player.start();

        //현재 서비스를 강화하여 절대로 죽지않는 좀비로 변신
        //startForeground(id, Notification);

        //상태창 없이 좀비서비스 구현
        startForeground(1, new Notification());//저리 꺼져!!! 싫은데????

        //return 이 서비스의 실행 유형(강제 종료시 대처 방법);
        return START_STICKY;//저리 꺼져!! 응 알았어... 라고 할줄 알았지?
        //return START_NOT_STICKY;//저리 꺼져!! 응 알았어...
        //return START_REDELIVER_INTENT;//STICKY 와 같은데... intent를 유지(다운로드시 사용)
    }

    @Override
    public void onDestroy() {
        //플레이어를 소멸
        if(player != null){
            if(player.isPlaying()){
                player.stop();
            }
            player = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
