package cn.teek.base.network;

import androidx.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestHelper {
    /**
     * 获取Retrofit 服务端API
     * @param interceptor oktttp拦截器，可以为空
     * @param url 请求的base url
     * @param apiClazz Retrofit API 类的Class
     * @param <T>
     * @return
     */
    public static <T> T getNetworkApi(Interceptor interceptor, @NonNull String url, @NonNull Class<T> apiClazz) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (interceptor != null) {
            builder.addInterceptor(interceptor);
        }
        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        return retrofit.create(apiClazz);
    }

    /**
     * 发起请求，在子线程请求，主线程回调
     * @param observable 调用Retrofit api获得的用于rxjava的Observable
     * @param observer  需要注册的Observer，用户获取异步回调
     */
    public static void requestAysnc(Observable observable, Observer observer) {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

}
