package com.example.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.notificationexample.NotificationCreator.CHANEL_ID_1;
import static com.example.notificationexample.NotificationCreator.CHANEL_ID_2;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private EditText title, desc;
    private Button chanel_1, chanel_2;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObjects();
        initListeners();
    }

    private void initObjects() {
        context = this;
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        chanel_1 = findViewById(R.id.chanel1);
        chanel_2 = findViewById(R.id.chanel2);
        notificationManager = NotificationManagerCompat.from(this);
    }

    private void initListeners() {
        chanel_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChanel1();
            }
        });

        chanel_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senOnChanel2();
            }
        });
    }

    private void sendOnChanel1() {
        Log.i("TAG", "sendOnChanel 1: entered");
        Notification notification = new NotificationCompat.Builder(context, CHANEL_ID_1)
                .setSmallIcon(R.drawable.ic_first_chanel_icon)
                .setContentTitle(title.getText().toString().isEmpty() ? "chanel 1" : title.getText().toString())
                .setContentText(desc.getText().toString().isEmpty() ? "chanel 1 description" : desc.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);

    }

    private void senOnChanel2() {
        Log.i("TAG", "sendOnChanel 2: entered");
        Notification notification = new NotificationCompat.Builder(context, CHANEL_ID_2)
                .setSmallIcon(R.drawable.ic_second_chanel_icon)
                .setContentTitle(title.getText().toString().isEmpty() ? "chanel 2" : title.getText().toString())
                .setContentText(desc.getText().toString().isEmpty() ? "chanel 2 description" : desc.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .build();

        notificationManager.notify(2, notification);

    }
}