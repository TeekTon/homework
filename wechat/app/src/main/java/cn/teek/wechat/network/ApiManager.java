package cn.teek.wechat.network;

import cn.teek.base.network.RequestHelper;
import cn.teek.wechat.network.api.CommonApi;

/**
 * 服务端接口管理类，可以根据不同url注册不同的API
 */
public class ApiManager {
    private static volatile ApiManager sInstance;
    private CommonApi mCommonApi;

    public static ApiManager getInstance() {
        if (sInstance == null) {
            synchronized (ApiManager.class) {
                if (sInstance == null) {
                    sInstance = new ApiManager();
                }
            }
        }
        return sInstance;
    }

    private ApiManager() {
        mCommonApi = RequestHelper.getNetworkApi(null, CommonApi.BASE_URL, CommonApi.class);
    }

    public CommonApi getCommonApi() {
        return mCommonApi;
    }
}
