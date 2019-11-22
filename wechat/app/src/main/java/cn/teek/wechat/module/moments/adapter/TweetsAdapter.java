package cn.teek.wechat.module.moments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.teek.wechat.R;
import cn.teek.wechat.image.ImageLoaderUtils;
import cn.teek.wechat.model.TweetBean;

/**
 * 推文列表数据适配器
 */
public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.MyViewHolder> {
    //推文列表
    private List<TweetBean> mTweets;
    private Context mContext;

    public TweetsAdapter(Context context, List<TweetBean> tweets) {
        mContext = context;
        mTweets = tweets;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_moments_tweet, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TweetBean tweetBean = mTweets.get(position);
        if (tweetBean == null) return;
        holder.tvContent.setText(tweetBean.getContent());
        TweetBean.SenderEntity sender = tweetBean.getSender();
        if (sender == null) return;
        holder.tvNick.setText(sender.getNick());
        ImageLoaderUtils.getInstance().loadImage(mContext, sender.getAvatar(), holder.ivAvatar);
    }


    @Override
    public int getItemCount() {
        return mTweets == null ? 0 : mTweets.size();
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
