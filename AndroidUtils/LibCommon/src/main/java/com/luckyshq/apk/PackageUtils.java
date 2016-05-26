package com.luckyshq.apk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;

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

	public static String getCurProcessName(Context pContext) {
		int pid = Process.myPid();
		ActivityManager activityManager = (ActivityManager) pContext.getSystemService(Context.ACTIVITY_SERVICE);
		for (RunningAppProcessInfo appProcessInfo : activityManager.getRunningAppProcesses()){
			if (appProcessInfo.pid == pid) {
				return appProcessInfo.processName;
			}
		}
		return null;
	}
}
