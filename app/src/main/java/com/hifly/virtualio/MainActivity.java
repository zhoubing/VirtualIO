package com.hifly.virtualio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IVirtualioService;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IBinder service = ServiceManager.getService("virtualio");
        IVirtualioService iVirtualioService = IVirtualioService.Stub.asInterface(service);
        try {
            iVirtualioService.setReg(8);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            int reg = iVirtualioService.getReg();
            Log.d("MainActivity", "reg: " + reg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}