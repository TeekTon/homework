package cn.teek.base.utils;

import android.util.Log;

import cn.teek.base.BuildConfig;

public class LogUtils {
    private static final String TAG="LogUtils";
    private static final boolean DEBUG_MODE = BuildConfig.LOG_ENABLE;
    public static void w(String tag,String content){
        if(DEBUG_MODE){
            Log.w(tag,content);
        }
    }
    public static void d(String tag,String content){
        if(DEBUG_MODE){
            Log.d(tag,content);
        }
    }
    public static void e(String tag,String content){
        if(DEBUG_MODE){
            Log.e(tag,content);
        }
    }
    public static void i(String tag,String content){
        if(DEBUG_MODE){
            Log.i(tag,content);
        }
    }

    public static void v(String tag,String content){
        if(DEBUG_MODE){
            Log.v(tag,content);
        }
    }
}
