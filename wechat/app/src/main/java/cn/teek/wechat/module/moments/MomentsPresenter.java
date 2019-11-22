package cn.teek.wechat.module.moments;

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
                    }
                });
    }

    @Override
    public void getTweetList() {

    }

    @Override
    public void onStart() {
        getUserInfo();
    }
}
