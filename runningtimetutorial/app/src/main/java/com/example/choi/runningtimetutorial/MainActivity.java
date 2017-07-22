package com.example.choi.runningtimetutorial;

import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);long currentMillis = Calendar.getInstance().getTimeInMillis();
        Calendar cal = Calendar.getInstance();

        for (ActivityManager.RunningServiceInfo info : services) {
            cal.setTimeInMillis(currentMillis-info.activeSince);

            Log.i("asd", String.format("Process %s with component %s has been running since %s (%d milliseconds)",
                    info.process, info.service.getClassName(), cal.getTime().toString(), info.activeSince));
        }
    }
}
