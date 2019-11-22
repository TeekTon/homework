package cn.teek.wechat.module.moments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.teek.base.utils.StringUtils;
import cn.teek.wechat.R;
import cn.teek.wechat.base.BaseFragment;
import cn.teek.wechat.model.UserInfoBean;

public class MomentsFragment extends BaseFragment<MomentsPresenter> implements MomentsContact.View {

    //头像
    private ImageView mIvAvatar;
    //朋友圈背景
    private ImageView mIvHeader;
    //昵称
    private TextView mTvNick;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_moments_home;
    }

    @Override
    protected void initViews(View rootView) {
        mIvAvatar = rootView.findViewById(R.id.iv_avatar);
        mIvHeader = rootView.findViewById(R.id.iv_header);
        mTvNick = rootView.findViewById(R.id.tv_nick);
        mPresenter.onStart();
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MomentsPresenter(this);
    }

    @Override
    public void updateUserInfo(UserInfoBean userInfoBean) {
        mTvNick.setText(StringUtils.toNotNullStr(userInfoBean.getNick()));
    }

    @Override
    public void updateTweeList() {

    }
}
