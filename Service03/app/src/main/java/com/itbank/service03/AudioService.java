package com.itbank.service03;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class AudioService extends Service {

    private MediaPlayer player;

    //onCreate(), onStartCommand(), onDestroy()를 추가 재정의
    @Override
    public void onCreate() {
        //시작 준비
        if(player == null){
            player = MediaPlayer.create(getApplicationContext(), R.raw.palette);
            player.setLooping(false);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //핵심 구동 코드 구현
        if(player != null)  player.start();

        //재생에 필요한 서비스 환경을 구축

        NotificationCompat.Builder builder = new NotificationCompat.Builder(AudioService.this);
        builder.setContentTitle("음악 재생중");
        builder.setContentText("곡정보 : IU(아이유) - Palette");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        //누르면 이동할 수 있도록 PendingIntent를 정의

        Intent move = new Intent(AudioService.this, MainActivity.class);

        //PendingIntent pendingIntent = PendingIntent.getActivity(소속, 요청번호, 행위(대상), 플래그(상태값));
        PendingIntent pendingIntent = PendingIntent.getActivity(AudioService.this, 0, move, 0);
        builder.setContentIntent(pendingIntent);
        //builder.setFullScreenIntent(pendingIntent, true);//화면을 덮는 알림창이 등장

        //눌러서 이동할 때 액티비티 재생성을 방지하고 싶다면 매니페스트에 해당 액티비티 속성을 추가
        //android:launchMode="singleTop"

        Notification noti = builder.build();

        //[1] 강제 종료해도 죽지 않도록 구현(with 알림창)
        startForeground(9876, noti);

        //[2] 서비스의 기본 종료 유형 정의
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        //종료 준비
        if(player != null){
            if(player.isPlaying()){
                player.stop();
            }
            player = null;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;//연결할 생각이 없습니다...
    }
}
