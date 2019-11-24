package cn.teek.wechat.module.moments;

import java.util.List;

import cn.teek.wechat.base.mvp.BasePresenter;
import cn.teek.wechat.base.mvp.BaseView;
import cn.teek.wechat.model.TweetBean;
import cn.teek.wechat.model.UserInfoBean;

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
