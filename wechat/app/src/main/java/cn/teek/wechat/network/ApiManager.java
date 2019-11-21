package cn.teek.wechat.network;

public class ApiManager {
    private static volatile ApiManager sInstance;

    private static ApiManager getInstance() {
        if (sInstance == null) {
            synchronized (ApiManager.class) {
                if (sInstance == null) {
                    sInstance = new ApiManager();
                }
            }
        }
        return sInstance;
    }

}
