package com.luckyshq.androidutils.apk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import com.luckyshq.apk.PackageUtils;

/**
 * Created by zhangshengqi on 16/5/11.
 */
public class PackageInfoService extends Service {
	private static final int MSG_SHOW_TOAST = 0;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case MSG_SHOW_TOAST:
					Toast.makeText(PackageInfoService.this, PackageUtils.getTopPackageName(PackageInfoService.this), Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
			}
			super.handleMessage(msg);
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		startPrintTopPackageName();
	}

	private void startPrintTopPackageName() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					mHandler.sendEmptyMessage(MSG_SHOW_TOAST);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException pE) {
						pE.printStackTrace();
					}
				}
			}
		}).start();
	}
}
