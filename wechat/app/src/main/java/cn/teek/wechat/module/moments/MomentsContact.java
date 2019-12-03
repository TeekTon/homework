package cn.teek.wechat.module.moments;

import java.util.List;

import cn.teek.wechat.base.mvp.BasePresenter;
import cn.teek.wechat.base.mvp.BaseView;
import cn.teek.wechat.data.bean.TweetBean;
import cn.teek.wechat.data.bean.UserInfoBean;

public interface MomentsContact {
    interface Presenter extends BasePresenter {
        void getUserInfo();
        void refreshTweetList();
        void loadMoreTweets();
    }

    interface View extends BaseView {
        void updateUserInfo(UserInfoBean userInfoBean);

        void refreshTweeList(List<TweetBean> tweetBeans);

        void onLoadMoreTweetsFinished(List<TweetBean> batchFiveTweets);
    }

}
