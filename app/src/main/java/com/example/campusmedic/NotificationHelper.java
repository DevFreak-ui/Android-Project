package com.example.campusmedic;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channel1ID";
    public static final String channelName = "Channel 1";

    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        createChannel();
    }

    private void createChannel () {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
        channel.enableLights(true);
        channel.enableVibration(true);
        channel.setLightColor(R.color.lavender);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return mManager;
    }

    public NotificationCompat.Builder getChannel1Notification() {
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Event Sign Up")
                .setContentText("You just Signed-Up for Fitness Events")
                .setColor(Color.rgb(134,146,247))
                .setSmallIcon(R.drawable.baseline_notifications_active_24);
    }
}
