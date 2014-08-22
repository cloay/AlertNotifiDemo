package com.cloay.alertnotifidemo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
/**
 * 
 * @ClassName: MyService 
 * @Description:  
 * @author cloay Email:shangrody@gmail.com 
 * @date 2014-8-22 ÏÂÎç6:20:11 
 *
 */
public class MyService extends Service {
	private MyReceiver receiver;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		receiver = new MyReceiver();
		IntentFilter filter = new IntentFilter();
        filter.addAction("com.cloay.receiver");
        registerReceiver(receiver,filter);
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Log.v("AlertNotifi", "I am running.....");
				
				KeyguardManager mKeyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
				if (!mKeyguardManager.inKeyguardRestrictedInputMode()) {
					Log.v("AlertNotifi", "Screen is on.....");
				}else{
					Log.v("AlertNotifi", "Screen is off.....");
					Intent intentReceiver = new Intent("com.cloay.receiver");
					sendBroadcast(intentReceiver);
				}
			}
		}, 10*1000, 10*1000);   //send a new message every 10 seconds.
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}

	
}
