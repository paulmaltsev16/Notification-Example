package com.example.notificationexample;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class NotificationCreator extends Application {

    public static final String CHANEL_ID_1 = "CHANEL_1";
    public static final String CHANEL_ID_2 = "CHANEL_2";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotification();
    }

    private void createNotification() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANEL_ID_1,
                    "name of 1 chanel",
                    NotificationManager.IMPORTANCE_HIGH);

            NotificationChannel channel2 = new NotificationChannel(
                    CHANEL_ID_2,
                    "name of 2 chanel",
                    NotificationManager.IMPORTANCE_LOW);

            channel1.setDescription("setDescription Method1");
            channel2.setDescription("setDescription Method2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);


        }


    }
}
