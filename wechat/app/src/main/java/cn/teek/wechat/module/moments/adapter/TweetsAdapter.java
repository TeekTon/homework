package cn.teek.wechat.module.moments.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.teek.base.utils.CommonUtils;
import cn.teek.wechat.R;
import cn.teek.wechat.image.ImageLoaderUtils;
import cn.teek.wechat.model.TweetBean;
import cn.teek.wechat.model.UserInfoBean;

/**
 * 推文列表数据适配器
 */
public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.MyViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_TWEET = 1;
    //推文列表
    private List<TweetBean> mTweets;
    private Context mContext;
    private View mHeaderLayout;

    public TweetsAdapter(Context context, List<TweetBean> tweets) {
        mContext = context;
        mTweets = tweets;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            mHeaderLayout = LayoutInflater.from(mContext).inflate(R.layout.item_tweet_header, parent, false);
            return new MyViewHolder(mHeaderLayout);
        }
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_moments_tweet, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (position == 0) {
            //处理头部
        } else {
            TweetBean tweetBean = mTweets.get(position - 1);
            if (tweetBean == null) return;

            //更新推文内容
            if (TextUtils.isEmpty(tweetBean.getContent())) {
                holder.tvContent.setVisibility(View.GONE);
            } else {
                holder.tvContent.setVisibility(View.VISIBLE);
                holder.tvContent.setText(tweetBean.getContent());
            }

            //更新推文图片

            TweetBean.SenderEntity sender = tweetBean.getSender();
            if (sender == null) return;
            //更新推文发布者昵称
            holder.tvNick.setText(sender.getNick());
            //更新推文发布者头像
            ImageLoaderUtils.getInstance().loadImage(mContext, sender.getAvatar(), holder.ivAvatar);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_TWEET;
    }

    @Override
    public int getItemCount() {
        return mTweets == null ? 1 : mTweets.size() + 1;
    }

    /**
     * 下拉刷新
     *
     * @param tweetBeans 新数据
     */
    public void refreshData(List<TweetBean> tweetBeans) {
        if (CommonUtils.isListEmpty(tweetBeans))
            return;
        mTweets.clear();
        mTweets.addAll(tweetBeans);
        notifyDataSetChanged();
    }

    /**
     * 加载更多推文
     *
     * @param tweetBeans 推文数据
     */
    public void loadMoreTweets(List<TweetBean> tweetBeans) {
        if (CommonUtils.isListEmpty(tweetBeans))
            return;
        mTweets.addAll(tweetBeans);
        notifyDataSetChanged();
    }

    /**
     * 更新头部UI
     *
     * @param userInfoBean 用户数据
     */
    public void updateHeader(UserInfoBean userInfoBean) {
        ImageView ivAvatar = mHeaderLayout.findViewById(R.id.iv_avatar);
        ImageView ivHeader = mHeaderLayout.findViewById(R.id.iv_header);
        TextView tvNick = mHeaderLayout.findViewById(R.id.tv_nick);
        ImageLoaderUtils.getInstance().loadImage(mContext, userInfoBean.getAvatar(), ivAvatar);
        ImageLoaderUtils.getInstance().loadImage(mContext, userInfoBean.getProfileImage(), ivHeader);
        tvNick.setText(userInfoBean.getUsername());
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivAvatar;
        private TextView tvContent;
        private TextView tvNick;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNick = itemView.findViewById(R.id.tv_nick);
            tvContent = itemView.findViewById(R.id.tv_content);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
        }
    }
}
