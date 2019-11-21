package cn.teek.wechat.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.teek.wechat.base.mvp.BasePresenter;

/**
 * 应用所有Activity的基类，可以进行页面统计等共有操作
 */
public class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
