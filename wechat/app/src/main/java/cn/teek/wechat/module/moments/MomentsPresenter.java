package cn.teek.wechat.module.moments;

import java.util.List;

import cn.teek.base.utils.CommonUtils;
import cn.teek.wechat.model.TweetBean;
import cn.teek.wechat.model.UserInfoBean;
import cn.teek.wechat.network.ApiManager;
import cn.teek.wechat.network.BaseSingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MomentsPresenter implements MomentsContact.Presenter {
    private MomentsContact.View mMomentsView;

    public MomentsPresenter(MomentsContact.View view) {
        mMomentsView = view;
    }

    @Override
    public void getUserInfo() {
        ApiManager.getInstance()
                .getCommonApi()
                .getUserInfo("jsmith")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSingleObserver<UserInfoBean>() {
                    @Override
                    public void handleSuccess(UserInfoBean userInfoBean) {
                        if (userInfoBean == null) return;
                        mMomentsView.updateUserInfo(userInfoBean);
                        getTweetList();
                    }
                });
    }

    @Override
    public void getTweetList() {
        ApiManager.getInstance().getCommonApi()
                .getUserTweets("jsmith")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSingleObserver<List<TweetBean>>() {
                    @Override
                    public void handleSuccess(List<TweetBean> tweetBeans) {
                        if (CommonUtils.isListEmpty(tweetBeans)) {
                            return;
                        }
                        mMomentsView.updateTweeList(tweetBeans);
                    }
                });

    }

    @Override
    public void onStart() {
        getUserInfo();
    }
}
