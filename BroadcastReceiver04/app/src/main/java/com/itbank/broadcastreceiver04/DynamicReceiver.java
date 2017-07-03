package com.itbank.broadcastreceiver04;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by 연지점204강사 on 2017-07-01.
 */
public class DynamicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("이어폰 상태 변경");
        builder.setContentText(intent.getAction());
        builder.setSmallIcon(R.mipmap.ic_launcher);

        Intent in = new Intent(context, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context, 0, in, 0);
        builder.setFullScreenIntent(pi, true);

        Notification noti = builder.build();

        NotificationManager manager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(99999, noti);
    }
}
