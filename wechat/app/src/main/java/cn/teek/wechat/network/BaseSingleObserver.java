package cn.teek.wechat.network;

import android.widget.Toast;

import cn.teek.base.utils.LogUtils;
import cn.teek.wechat.MyApplication;
import cn.teek.wechat.R;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * 网络请求回调基类，可以在这里进行一些统一的响应处理
 *
 * @param <T>
 */
public abstract class BaseSingleObserver<T> implements SingleObserver<T> {
    private static final String TAG = "BaseSingleObserver";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(T t) {
        LogUtils.d(TAG, t== null ? "no data！！！" :t.toString());
        handleSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(MyApplication.sApplication, R.string.network_error, Toast.LENGTH_SHORT).show();
        handleError(-1, e.getMessage());
        LogUtils.d(TAG, "network error#" + e);
    }

    /**
     * 实现此方法处理响应成功
     *
     * @param t
     */
    public abstract void handleSuccess(T t);

    /**
     * 覆盖此方法处理错误
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public void handleError(int code, String message) {
    }
}
