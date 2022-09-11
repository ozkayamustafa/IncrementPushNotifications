package com.mustafa.incrementpushnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CounterNotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        CounterNotificationsService service = new CounterNotificationsService(context);
        service.showNotificaiton(++Counter.value);
    }
}
