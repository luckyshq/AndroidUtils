package com.luckyshq.os;

import java.lang.reflect.Method;

/**
 * Created by zhangshengqi on 16/2/24.
 */
public class ReflectSystemProperties {

	private static Class<?> mClassType = null;
	private static Method mGetMethod = null;
	private static Method mGetWithDefMethod = null;
	private static Method mGetIntMethod = null;
	private static Method mGetLongMethod = null;
	private static Method mGetBooleanMethod = null;
	private static Method mSetMethod = null;

	static {
		if (mClassType == null) {
			try {
				mClassType = Class.forName("android.os.SystemProperties");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String get(String key) {
		String value = null;
		try {
			if (mGetMethod == null) {
				mGetMethod = mClassType.getDeclaredMethod("get", String.class);
			}
			value = (String) mGetMethod.invoke(mClassType, key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public static String get(String key, String def) {
		String value = def;
		try {
			if (mGetWithDefMethod == null) {
				mGetWithDefMethod = mClassType.getDeclaredMethod("get", String.class, String.class);
			}
			value = (String) mGetWithDefMethod.invoke(mClassType, key, def);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static int getInt(String key, int def) {
		int value = def;
		try {
			if (mGetIntMethod == null) {
				mGetIntMethod = mClassType.getDeclaredMethod("getInt", String.class, int.class);
			}
			value = (Integer) mGetIntMethod.invoke(mClassType, key, def);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static Long getLong(String key, long def) {
		long value = def;
		try {
			if (mGetLongMethod == null) {
				mGetLongMethod = mClassType.getDeclaredMethod("getLong", String.class, long.class);
			}
			value = (Long) mGetLongMethod.invoke(mClassType, key, def);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static boolean getBoolean(String key, boolean def) {
		boolean value = def;
		try {
			if (mGetBooleanMethod == null) {
				mGetBooleanMethod = mClassType.getDeclaredMethod("getBoolean", String.class, boolean.class);
			}
			value = (Boolean) mGetBooleanMethod.invoke(mClassType, key, def);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void set(String key, String val) {
		try {
			if (mSetMethod == null) {
				mSetMethod = mClassType.getDeclaredMethod("set", String.class, String.class);
			}
			mSetMethod.invoke(mClassType, key, val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
