package cn.teek.wechat.module.moments;

import cn.teek.wechat.base.mvp.BasePresenter;
import cn.teek.wechat.base.mvp.BaseView;

public interface MomentsContact {
    interface Presenter extends BasePresenter {
        void getUserInfo();
        void getTweetList();
    }

    interface View extends BaseView {
        void updateUserInfo();

        void updateTweeList();
    }

}
