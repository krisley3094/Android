package com.itbank.broadcastreceiver02;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

public class ItbankReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //notification을 이용하여 전달된 데이터를 처리...단 정해진 액션에만 반응하도록 구현
        if(intent.getAction().equals("com.itbank.broadcast.MESSAGE")){

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setContentTitle("ITBANK");
            builder.setContentText(intent.getStringExtra("text"));
            builder.setSmallIcon(R.mipmap.ic_launcher);

            Intent in = new Intent(context, MainActivity.class);
            PendingIntent pi = PendingIntent.getActivity(context, 0, in, 0);
            builder.setFullScreenIntent(pi, true);

            Notification noti = builder.build();

            NotificationManager manager =
                    (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(9999, noti);
        }
    }
}












