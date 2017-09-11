package com.mostafaabdel_fatah.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Mostafa AbdEl_Fatah on 9/4/2017.
 */

public class MyService extends Service {

    class  MyThreadClass implements  Runnable {
        int serviceid;
        public  MyThreadClass(int serivceid){
            this.serviceid = serivceid;
        }
        @Override
        public void run() {
            synchronized (this) {

                for (int i = 0; i < 10; i++) {
                    try {
                        wait(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(this.serviceid);
            }
        }
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "service creating", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent , int flags , int startId) {

        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread( new MyThreadClass(startId));
        thread.start();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }
}
