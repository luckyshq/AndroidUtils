package com.luckyshq.libtoast;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by zhangshengqi on 15/10/21.
 */
public class TimeToast{
	private static final int CHECK_TOAST_ALIVE_TIME = 1000;

	private static Toast mToast;
	private static boolean mIsCanceled = false;
	private static Handler mHandler;

	public static void makeText(Context context, CharSequence charSequence) {
		mToast = Toast.makeText(context, charSequence, Toast.LENGTH_LONG);
	}

	public static void makeText(Context context, int resId) {
		mToast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
	}

	public static void show(){
		if (null == mToast){
			return;
		}
		if (null == mHandler) {
			mHandler = new Handler();
		}
		mIsCanceled = false;
		showUntilCanceled();
	}

	private static void showUntilCanceled(){
		if (!mIsCanceled){
			mToast.show();
			mHandler.postDelayed(new Runnable() {
				@Override
				public void run() {
					showUntilCanceled();
				}
			}, CHECK_TOAST_ALIVE_TIME);
		}
	}

	public static void cancelToast(){
		mIsCanceled = true;
		mToast.cancel();
	}

}
