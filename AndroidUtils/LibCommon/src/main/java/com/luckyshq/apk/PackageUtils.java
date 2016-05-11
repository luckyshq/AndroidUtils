package com.luckyshq.apk;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by zhangshengqi on 15/12/29.
 */
public class PackageUtils {

	public static String getTopActivityName(Context pContext){
		ActivityManager activityManager = (ActivityManager) pContext.getSystemService(Context.ACTIVITY_SERVICE);
		return activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
	}

	public static String getTopPackageName(Context pContext) {
		ActivityManager activityManager = (ActivityManager) pContext.getSystemService(Context.ACTIVITY_SERVICE);
		return activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
	}

}
