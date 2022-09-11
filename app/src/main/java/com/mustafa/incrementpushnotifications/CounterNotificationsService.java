package com.mustafa.incrementpushnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class CounterNotificationsService {
    private Context context;
    private NotificationManager notificationManager;
    CounterNotificationsService(Context context){
        this.context = context;
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void showNotificaiton(int counter){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Intent activityIntent = new Intent(context,MainActivity.class);
            PendingIntent pendingActivtyIntent = PendingIntent.getActivity(context,
                    1,
                    activityIntent,
                     PendingIntent.FLAG_IMMUTABLE
                    );
            Intent broadcastIntent = new Intent(context,CounterNotificationReceiver.class);
            PendingIntent pendingBroadcastIntent = PendingIntent.getBroadcast(context,2, broadcastIntent,PendingIntent.FLAG_IMMUTABLE);

            Notification builder = new NotificationCompat.Builder(context,CounterNotificationsService.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_pizza)
                    .setContentTitle("Counter")
                    .setContentText("Increment Counter: "+counter)
                    .setContentIntent(pendingActivtyIntent)
                    .addAction(
                            R.drawable.ic_pizza,
                            "Increment",
                            pendingBroadcastIntent)
                    .build();
            notificationManager.notify(1,builder);
        }
    }
    final static String CHANNEL_ID="channel_id";

}
