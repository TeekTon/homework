package cn.teek.wechat.module.moments;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import cn.teek.base.utils.CommonUtils;
import cn.teek.base.utils.LogUtils;
import cn.teek.wechat.R;
import cn.teek.wechat.base.BaseFragment;
import cn.teek.wechat.data.bean.TweetBean;
import cn.teek.wechat.data.bean.UserInfoBean;
import cn.teek.wechat.module.moments.adapter.TweetsAdapter;
import cn.teek.wechat.widgets.OnRecyclerViewScrollListener;

public class MomentsFragment extends BaseFragment<MomentsPresenter> implements MomentsContact.View {

    private static final String TAG = "MomentsFragment";
    //推文列表
    private RecyclerView mRvTweets;
    //推文数据适配器
    private TweetsAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_moments_home;
    }

    @Override
    protected void initViews(View rootView) {
        mRvTweets = rootView.findViewById(R.id.rv_tweets);
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        //初始列表
        mRvTweets.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new TweetsAdapter(getActivity(), new ArrayList<>());
        mRvTweets.setAdapter(mAdapter);

        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.onStart();
    }

    @Override
    protected void initListeners() {
        mRvTweets.addOnScrollListener(new OnRecyclerViewScrollListener() {
            @Override
            public void onBottom() {
                LogUtils.d(TAG, "滑动到了底部");
                mPresenter.loadMoreTweets();
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refreshTweetList();
            }
        });
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MomentsPresenter(this);
    }

    @Override
    public void updateUserInfo(UserInfoBean userInfoBean) {
        if (getActivity() == null) return;
        mAdapter.updateHeader(userInfoBean);
    }

    @Override
    public void refreshTweeList(List<TweetBean> tweetBeans) {
        if (getActivity() == null) return;
        mSwipeRefreshLayout.setRefreshing(false);
        if (CommonUtils.isListEmpty(tweetBeans)) {
            return;
        }
        mAdapter.refreshData(tweetBeans);
    }

    @Override
    public void onLoadMoreTweetsFinished(List<TweetBean> tweetBeans) {
        if (CommonUtils.isListEmpty(tweetBeans))
            return;
        mAdapter.loadMoreTweets(tweetBeans);
    }
}
