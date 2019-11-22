package cn.teek.wechat.module.moments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.teek.base.utils.StringUtils;
import cn.teek.wechat.R;
import cn.teek.wechat.base.BaseFragment;
import cn.teek.wechat.image.ImageLoaderUtils;
import cn.teek.wechat.model.TweetBean;
import cn.teek.wechat.model.UserInfoBean;
import cn.teek.wechat.module.moments.adapter.TweetsAdapter;

public class MomentsFragment extends BaseFragment<MomentsPresenter> implements MomentsContact.View {

    //头像
    private ImageView mIvAvatar;
    //朋友圈背景
    private ImageView mIvHeader;
    //昵称
    private TextView mTvNick;
    //推文列表
    private RecyclerView mRvTweets;
    //推文数据适配器
    private TweetsAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_moments_home;
    }

    @Override
    protected void initViews(View rootView) {
        mIvAvatar = rootView.findViewById(R.id.iv_avatar);
        mIvHeader = rootView.findViewById(R.id.iv_header);
        mTvNick = rootView.findViewById(R.id.tv_nick);
        mRvTweets = rootView.findViewById(R.id.rv_tweets);
        mRvTweets.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPresenter.onStart();
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MomentsPresenter(this);
    }

    @Override
    public void updateUserInfo(UserInfoBean userInfoBean) {
        if (getActivity() == null) return;
        mTvNick.setText(StringUtils.toNotNullStr(userInfoBean.getNick()));

        ImageLoaderUtils.getInstance().loadImage(getActivity(), userInfoBean.getProfileImage(), mIvHeader);
        ImageLoaderUtils.getInstance().loadImage(getActivity(), userInfoBean.getAvatar(), mIvAvatar);
    }

    @Override
    public void updateTweeList(List<TweetBean> tweetBeans) {
        if (getActivity() == null) return;
        mAdapter = new TweetsAdapter(getActivity(), tweetBeans);
        mRvTweets.setAdapter(mAdapter);
    }
}
