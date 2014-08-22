package com.cloay.alertnotifidemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
/**
 * 
 * @ClassName: AlertActivity 
 * @Description:  
 * @author cloay Email:shangrody@gmail.com 
 * @date 2014-8-22 ÏÂÎç6:20:33 
 *
 */
public class AlertActivity extends Activity implements OnClickListener{

	private TextView titleTextV;
	private TextView msgTextV;
	
	private Button cancleBtn;
	private Button okBtn;
	@SuppressLint("ShowToast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		setContentView(R.layout.alert_layout);
		
		titleTextV = (TextView) findViewById(R.id.msg_title_textV);
		titleTextV.setText("New message: ");
		msgTextV = (TextView) findViewById(R.id.msg_content_textV);
		msgTextV.setText("Hi, I am cloay!");
		
		cancleBtn = (Button) findViewById(R.id.alert_cancle_btn);
		cancleBtn.setOnClickListener(this);
		okBtn = (Button) findViewById(R.id.alert_ok_btn);
		okBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		if(v == cancleBtn){
			DevicePolicyManager policyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
			policyManager.lockNow();
			new Handler().postDelayed(new Runnable() {
				
				@Override
				public void run() {
					finish();
				}
			}, 1000);
		}else if(v == okBtn){
			//back to app 
			finish();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}
	
	
}
