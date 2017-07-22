package com.example.choi.dtoi.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;

/**
 * Created by choi on 2017. 7. 22..
 */

public class BluetoothService extends Service {
    BluetoothSPP BluetoothSpp;
    Boolean isFirstReceive=true;
    String Receive;

    @Override
    public void onCreate() {
        super.onCreate();
        BluetoothSpp = new BluetoothSPP(this);
        if (!BluetoothSpp.isBluetoothEnabled()) {
            BluetoothSpp.enable();
        } else {
            if (!BluetoothSpp.isServiceAvailable()) {
                BluetoothSpp.setupService();
                BluetoothSpp.startService(BluetoothState.DEVICE_OTHER);
                setup();
            }
        }
        isFirstReceive=true;
        Log.d("asd","asd");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        BluetoothSpp.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener() {
            public void onDeviceConnected(String name, String address) {
                Toast.makeText(getApplicationContext()
                        , "연결되었습니다", Toast.LENGTH_SHORT).show();
            }
            public void onDeviceDisconnected() {
                Toast.makeText(getApplicationContext()
                        , "연결이끊겼습니다"
                        , Toast.LENGTH_SHORT).show();
                isFirstReceive = true;
            }
            public void onDeviceConnectionFailed() {
            }
        });

        BluetoothSpp.setAutoConnectionListener(new BluetoothSPP.AutoConnectionListener() {
            public void onNewConnection(String name, String address) {
            }
            public void onAutoConnectionStarted() {
            }
        });

        BluetoothSpp.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            public void onDataReceived(byte[] data, String message) {
                Receive = message;
                if(isFirstReceive){
                    Toast.makeText(getApplicationContext(),Receive+"번 탑승",Toast.LENGTH_SHORT).show();
                    isFirstReceive = !isFirstReceive;
                }
            }
        });


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    public void setup() {
        BluetoothSpp.autoConnect("SUNRIN");
    }

    public void onDestroy() {
        super.onDestroy();
        BluetoothSpp.stopService();
    }
}
