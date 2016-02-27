package com.zl.lock.activity;

import com.zl.lock.R;
import com.zl.lock.R.layout;
import com.zl.lock.config.Config;
import com.zl.lock.server.LockService;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

// ----------2015.4.29-------------------------
//-----------整合了锁屏和单词本——-------------------

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
		// getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		// getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

		if (Config.SERVER_RUN == 0) {
			// -----服务未启动---------
			Intent intent2 = new Intent(this, LockService.class);
			startService(intent2);
		}
	}


	// ------------------按钮点击事件------------------------------------
	// ------------------start--------------------------------------
	public void startAdd(View v) {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, AddWordActivity.class);
		startActivity(intent);

	}

	public void startFindAll(View v) {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, WordsbookActivity.class);
		startActivity(intent);

	}
	// ------------------按钮点击事件------------------------------------
	// ------------------end--------------------------------------
}
