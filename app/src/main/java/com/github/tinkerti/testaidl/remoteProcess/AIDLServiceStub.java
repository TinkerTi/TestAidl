package com.github.tinkerti.testaidl.remoteProcess;

import android.os.RemoteException;
import android.util.Log;

import com.github.tinkerti.testaidl.IMyAidlInterface;

/**
 * Created by tiankui on 6/1/17.
 */

public class AIDLServiceStub extends IMyAidlInterface.Stub {

    @Override
    public void testAIDL(String name) throws RemoteException {
        Log.e("AIDLServiceStub", name + "....");
    }
}
