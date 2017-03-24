package com.hds.androidutils.utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/3/20.
 */
public class L {

    public static final boolean isDebug = true;
    public static final String TAG = "-------->";

    public static void d(String msg) {
        if(isDebug) {
            Log.d(TAG, msg);
        }
    }
    public static void d(String tag, String msg) {
        if(isDebug) {
            Log.d(tag, msg);
        }
    }
    public static void i(String msg) {
        if(isDebug) {
            Log.i(TAG, msg);
        }
    }
    public static void i(String tag, String msg) {
        if(isDebug) {
            Log.i(tag, msg);
        }
    }
    public static void w(String msg) {
        if(isDebug) {
            Log.w(TAG, msg);
        }
    }
    public static void w(String tag, String msg) {
        if(isDebug) {
            Log.w(tag, msg);
        }
    }
    public static void e(String msg) {
        if(isDebug) {
            Log.e(TAG, msg);
        }
    }
    public static void e(String tag, String msg) {
        if(isDebug) {
            Log.e(tag, msg);
        }
    }

}
