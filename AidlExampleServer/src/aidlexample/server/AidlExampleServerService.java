package aidlexample.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import aidlexample.IRemoteService;

public class AidlExampleServerService extends Service {

	
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(AidlExampleServerService.class.getSimpleName(), "onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int rv = super.onStartCommand(intent, flags, startId);
		Log.d(AidlExampleServerService.class.getSimpleName(), "onStartCommand");
		return rv;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(AidlExampleServerService.class.getSimpleName(), "onBind");
		return mBinder;
	}
	
	private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
	    public int getPid(){
	        return 0;
	    }
	    public void basicTypes(int anInt, long aLong, boolean aBoolean,
	        float aFloat, double aDouble, String aString) {
	        // Does nothing
	    }
	    public int add(int a, int b){
	    	return a+b;
	    }
	};
	
}
