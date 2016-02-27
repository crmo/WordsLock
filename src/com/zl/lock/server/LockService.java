package com.zl.lock.server;


import com.zl.lock.config.Config;
import com.zl.lock.view.LockView;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;


public class LockService extends Service {
	WindowManager windowManager;
	View view;
	EditText et;
	String word;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		Config.SERVER_RUN = 0;
		super.onDestroy();
	}

	@Override
	public void onCreate() {
		registerScreenActionReceiver();
		Config.SERVER_RUN = 1;
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		LockView.initLockView(getApplicationContext());
		return super.onStartCommand(intent, flags, startId);
	}

	private void registerScreenActionReceiver() {
		final IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		// filter.addAction(Intent.ACTION_SCREEN_ON);
		registerReceiver(receiver, filter);
	}

	private BroadcastReceiver receiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, final Intent intent) {
//			Intent intent2 = new Intent(context, LockService.class);
//			context.startService(intent2);
			System.out.println(" ’µΩπ„≤•");
			LockView.initLockView(getApplicationContext());
		}

	};

	

}
