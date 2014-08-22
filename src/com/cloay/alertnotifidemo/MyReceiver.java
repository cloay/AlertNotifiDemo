package com.cloay.alertnotifidemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/**
 * 
 * @ClassName: MyReceiver 
 * @Description: 
 * @author cloay Email:shangrody@gmail.com 
 * @date 2014-8-22 обнГ6:20:19 
 *
 */
public class MyReceiver extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context context, Intent intent) {
		//
		Log.v("AlertNotifi", "on receive.....");
		
		Intent intentAlert = new Intent(context, AlertActivity.class);
		intentAlert.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intentAlert);
	}
}
