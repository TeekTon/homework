package cn.teek.wechat.utils;

import android.text.TextUtils;

import com.google.gson.Gson;

import cn.teek.base.utils.LogUtils;

/**
 * json解析工具类
 */
public class GsonUtils {
    private static final String TAG = "GsonUtils";
//    public static <T> List<T> jsonToList(String json) {
//        if (TextUtils.isEmpty(json)) return null;
//        Type type = new TypeToken<List<T>>() {
//        }.getType();
//
//        return new Gson().fromJson(json, type);
//    }


    public static <T> T jsonToObj(String json, Class<T> clazz) {
        if (TextUtils.isEmpty(json))
            return null;
        try {
            T t = new Gson().fromJson(json, clazz);
            return t;
        } catch (Exception e) {
            return null;
        }
    }

    public static String objToJson(Object obj) {
        String json = "";
        try {
            json = new Gson().toJson(obj);
        } catch (Throwable e) {
            LogUtils.e(TAG, "objToJson error:" + e);
        }
        return json;
    }
}
