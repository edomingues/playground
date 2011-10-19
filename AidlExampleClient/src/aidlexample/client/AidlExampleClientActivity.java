package aidlexample.client;

import aidlexample.IRemoteService;
import aidlexample.server.AidlExampleServerService;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AidlExampleClientActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        System.err.println("beforeBind");
        
        Intent intent = new Intent("aidlexample.server.action.REMOTE");
        bindService(intent, mConnection, BIND_AUTO_CREATE);
        //startService(intent);
        
        System.err.println("afterBind");
                
        
    }
    
    private void work(){
    	if(mIRemoteService==null){
        	Log.e(AidlExampleClientActivity.class.getSimpleName(), "mIRemoteService==null!!");
        }
        else{
	        int r = 0;
	        try {
				r = mIRemoteService.add(5, 2);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Log.d(AidlExampleClientActivity.class.getSimpleName(), String.valueOf(r));
        }
    }
    
    IRemoteService mIRemoteService;
    private ServiceConnection mConnection = new ServiceConnection() {
        // Called when the connection with the service is established
        public void onServiceConnected(ComponentName className, IBinder service) {
            // Following the example above for an AIDL interface,
            // this gets an instance of the IRemoteInterface, which we can use to call on the service
        	Log.d(ServiceConnection.class.getSimpleName(), "onServiceConnected");
            mIRemoteService = IRemoteService.Stub.asInterface(service);
            work();
        }

        // Called when the connection with the service disconnects unexpectedly
        public void onServiceDisconnected(ComponentName className) {
            Log.e(ServiceConnection.class.getSimpleName(), "Service has unexpectedly disconnected");
            mIRemoteService = null;
        }
    };
}