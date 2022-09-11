package com.mustafa.incrementpushnotifications;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotification();
    }

    private void createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CounterNotificationsService.CHANNEL_ID,
                    "counter",
                    NotificationManager.IMPORTANCE_DEFAULT
                    );
            channel.setDescription("Increment counter");
            NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }

    }

public void onShowNotification(View view){
        CounterNotificationsService service = new CounterNotificationsService(getApplicationContext());
        service.showNotificaiton(Counter.value);
}


}
