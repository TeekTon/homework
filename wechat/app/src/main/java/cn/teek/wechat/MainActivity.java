package cn.teek.wechat;

import android.os.Bundle;

import cn.teek.wechat.base.BaseActivity;
import cn.teek.wechat.module.moments.MomentsFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_content, new MomentsFragment())
                .commit();
    }
}
