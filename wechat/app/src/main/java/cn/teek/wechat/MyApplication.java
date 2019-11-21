package cn.teek.wechat;

import android.app.Application;
import android.content.Context;

/**
 * 应用生命周期管理类，进行一些初始化操作
 */
public class MyApplication extends Application {
    public static Context sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        //做一些初始化操作
        sApplication = this;
    }
}
