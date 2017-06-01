package com.github.tinkerti.testaidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.tinkerti.testaidl.remoteProcess.AIDLService;

public class MainActivity extends AppCompatActivity {

    IMyAidlInterface proxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, AIDLService.class);
        bindService(intent, new AIDLServiceConnection(), BIND_AUTO_CREATE);
    }

    public void testAIDL(View view) {
        try {
            proxy.testAIDL("just test");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public class AIDLServiceConnection implements ServiceConnection {
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            proxy = IMyAidlInterface.Stub.asInterface(service);
        }
    }
}
