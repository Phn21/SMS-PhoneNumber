package com.example.day4sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number, sms;

    String stNum, stMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sms = findViewById(R.id.sms);
        number = findViewById(R.id.number);

        //Need this permissions with Manifest Permission.
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.SEND_SMS},
                1);

    }

    public void sendSms(View view) {

        stNum = number.getText().toString();
        stMessage = sms.getText().toString();

        Toast.makeText(this, "hi" + stNum + "\n" + stMessage, Toast.LENGTH_SHORT).show();

        SmsManager sm = SmsManager.getDefault();

        sm.sendTextMessage(stNum,null,stMessage,null, null);  // need also permission in manifest

    }
}