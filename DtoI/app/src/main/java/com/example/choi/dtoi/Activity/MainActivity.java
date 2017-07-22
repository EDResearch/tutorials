package com.example.choi.dtoi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.choi.dtoi.Service.BluetoothService;
import com.example.choi.dtoi.R;

public class MainActivity extends AppCompatActivity {
    Button btn,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.service_start);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startServiceMethod(v);
            }
        });
        stop = (Button) findViewById(R.id.service_stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopServiceMethod(v);
            }
        });
    }


    public void startServiceMethod(View v){
        Intent Service = new Intent(this, BluetoothService.class);
        startService(Service);
    }
    public void stopServiceMethod(View v){
        Intent Service = new Intent(this, BluetoothService.class);
        stopService(Service);
    }
}
