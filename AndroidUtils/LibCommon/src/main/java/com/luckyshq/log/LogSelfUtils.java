package com.luckyshq.log;

import android.util.Log;

/**
 * Created by zhangshengqi on 15/11/13.
 */
public class LogSelfUtils {


	/**
	 * 默认TAG，可自定义，长度不能超过23个字符。
	 */
	private static final String TAG = "Luckyshq";


	/**
	 * Log开关。
	 */
	private static final boolean IS_OPEN = true;


	/**
	 * @param msg verbose等级中要打印的log信息。
	 */
	public static void v(String msg){
		if (IS_OPEN){
			Log.v(TAG, msg);
		}
	}

	/**
	 * @param msg debug等级中要打印的log信息。
	 */
	public static void d(String msg){
		if (IS_OPEN){
			Log.d(TAG, msg);
		}
	}

	/**
	 * @param msg info等级中要打印的log信息。
	 */
	public static void i(String msg){
		if (IS_OPEN){
			Log.i(TAG, msg);
		}
	}


	/**
	 * @param msg warn等級中要打印的log信息。
	 */
	public static void w(String msg){
		if (IS_OPEN) {
			Log.w(TAG, msg);
		}
	}

	/**
	 * @param msg error等級中要打印的log信息。
	 */
	public static void e(String msg){
		if (IS_OPEN) {
			Log.e(TAG, msg);
		}
	}

}
