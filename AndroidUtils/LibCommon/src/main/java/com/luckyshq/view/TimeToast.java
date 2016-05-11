package com.luckyshq.view;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by luckyshq on 15/10/21.
 */
public class TimeToast{
	private static final int CHECK_TOAST_ALIVE_TIME = 1000;

	private static Toast mToast;
	private static boolean mIsCanceled = false;
	private static Handler mHandler;

	/**
	 * 初始化Toast
	 * @param charSequence Toast要显示的内容
	 */
	public static void makeText(Context context, CharSequence charSequence) {
		mToast = Toast.makeText(context, charSequence, Toast.LENGTH_LONG);
	}


	/**
	 * 初始化Toast
	 * @param resId Toast要显示内容对应的StringID
	 */
	public static void makeText(Context context, int resId) {
		mToast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
	}


	/**
	 * 显示Toast，只有先makeText之后才有效果
	 */
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

	/**
	 * 只要没调用过cancelToast，就一直显示Toast
	 */
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

	/**
	 * 取消Toast显示
	 */
	public static void cancelToast(){
		mIsCanceled = true;
		mToast.cancel();
	}

}
