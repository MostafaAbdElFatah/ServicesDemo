package com.mostafaabdel_fatah.servicesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartService_btnClicked(View view) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        startService(intent);
    }

    public void StopService_btnClicked(View view) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        stopService(intent);
    }
}
