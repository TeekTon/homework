package cn.teek.wechat.module.moments;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.teek.base.utils.CommonUtils;
import cn.teek.wechat.model.TweetBean;
import cn.teek.wechat.model.UserInfoBean;
import cn.teek.wechat.network.ApiManager;
import cn.teek.wechat.network.BaseSingleObserver;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MomentsPresenter implements MomentsContact.Presenter {
    private MomentsContact.View mMomentsView;
    //缓存当前页面的数据
    private ArrayList<TweetBean> mTweets;

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
                        refreshTweetList();
                    }
                });
    }

    @Override
    public void refreshTweetList() {
        if (mTweets != null) {
            mTweets.clear();
            mTweets = null;
        }
        ApiManager.getInstance().getCommonApi()
                .getUserTweets("jsmith")
                .subscribeOn(Schedulers.io())
                .map(tweetBeans -> {
                    filter(tweetBeans);
                    return mTweets;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSingleObserver<List<TweetBean>>() {
                    @Override
                    public void handleSuccess(List<TweetBean> tweetBeans) {
                        mMomentsView.refreshTweeList(batchFiveTweets());
                    }
                });

    }

    /**
     * 过滤不包含文字和图片的数据
     *
     * @param tweetBeans
     */
    private void filter(List<TweetBean> tweetBeans) {
        if (CommonUtils.isListEmpty(tweetBeans)) {
            return;
        }
        ArrayList<TweetBean> newTweets = new ArrayList<>();
        for (TweetBean tweetBean : tweetBeans) {
            if (TextUtils.isEmpty(tweetBean.getContent()) && CommonUtils.isListEmpty(tweetBean.getImages())) {
                continue;
            } else {
                newTweets.add(tweetBean);
            }
        }
        mTweets = newTweets;
    }

    /**
     * 获取5条推文数据
     */
    private List<TweetBean> batchFiveTweets() {
        if (CommonUtils.isListEmpty(mTweets))
            return null;
        ArrayList<TweetBean> tweetBeans = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            if (mTweets.isEmpty()) {
                break;
            }
            tweetBeans.add(mTweets.remove(0));
        }
        return tweetBeans;
    }

    @Override
    public void onStart() {
        getUserInfo();
    }

    /**
     * 加载更多推文
     */
    @Override
    public void loadMoreTweets() {
        Single.timer(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> mMomentsView.onLoadMoreTweetsFinished(batchFiveTweets()));
    }
}
