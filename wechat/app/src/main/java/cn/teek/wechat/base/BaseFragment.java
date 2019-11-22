package cn.teek.wechat.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.teek.wechat.base.mvp.BasePresenter;

/**
 * 所有Fragment的基类，可以进行统计等共有的操作
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), null);
        initViews(rootView);
        initListeners();
        return rootView;
    }

    /**
     * 返回根部局资源id
     * @return 资源id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化监听
     */
    private void initListeners() {

    }

    /**
     * 初始化布局
     *
     * @param rootView 页面的根部局
     */
    protected abstract void initViews(View rootView);


    /**
     * 覆盖此方法初始化Presenter，允许为空
     */
    protected abstract void initPresenter();
}
