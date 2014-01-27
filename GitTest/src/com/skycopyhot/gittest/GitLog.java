package com.skycopyhot.gittest;

import android.util.Log;

public class GitLog {

	public static void i(String tag, String msg) {
		if (Config.DEBUG) {
			Log.i(tag, msg);
		}
	}
	
	public static void d(String tag, String msg) {
		if (Config.DEBUG) {
			Log.d(tag, msg);
		}
	}
}
