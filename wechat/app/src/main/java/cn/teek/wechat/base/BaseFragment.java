package cn.teek.wechat.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.teek.wechat.base.mvp.BasePresenter;

/**
 * 所有Fragment的基类，可以进行统计等共有的操作
 */
public class BaseFragment<T extends BasePresenter> extends Fragment {
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mPresenter != null){
            mPresenter.onCreate();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mPresenter != null){
            mPresenter.onViewCreated();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.onDestroyed();
        }
    }
}
