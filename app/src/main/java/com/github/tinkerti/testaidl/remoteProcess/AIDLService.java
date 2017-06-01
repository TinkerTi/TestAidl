package com.github.tinkerti.testaidl.remoteProcess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by tiankui on 6/1/17.
 */

public class AIDLService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new AIDLServiceStub();
    }
}
