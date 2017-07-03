package com.itbank.broadcastreceiver01;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        context       소속
//        intent          전달된 요청 데이터(액션과 데이터가 존재)

//        Toast로 출력
//        Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();

//        Notification으로 출력
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
//        builder.setContentTitle("비행기모드 뿌잉뿌잉");
//        builder.setContentText("좋겠다 비행기도 타고");
//        builder.setSmallIcon(R.mipmap.ic_launcher);
//
//        Intent in = new Intent(context, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, in, 0);
//        //builder.setFullScreenIntent(pendingIntent, true);
//        builder.setContentIntent(pendingIntent);
//
//        Notification noti = builder.build();
//
//        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(9999, noti);

//        다이얼로그 출력
//        정상적으로는 다이얼로그가 출력되지 않는다(사용자의 행위를 방해하기 때문)
//        PendingIntent를 이용하여 꼼수로 생성
        Intent popup = new Intent(context, DialogActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context, 0, popup, PendingIntent.FLAG_ONE_SHOT);
        try{
            pi.send();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}















