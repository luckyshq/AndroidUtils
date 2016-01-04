package com.luckyshq.apk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by zhangshengqi on 15/12/29.
 */
public class PackageUtils {

	public static String getTopActivityName(Context context){
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		return activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
	}

}
