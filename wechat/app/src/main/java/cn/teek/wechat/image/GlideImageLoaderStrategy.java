package cn.teek.wechat.image;

import android.content.Context;

import com.bumptech.glide.Glide;

/**
 * 使用Glide加载图片的实现类
 */
public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy {
    @Override
    public void loadImage(Context context, ImageLoader imageLoader) {
        Glide.with(context)
                .load(imageLoader.getUrl())
                .placeholder(imageLoader.getPlaceHolder())
                .into(imageLoader.getImageView());
    }
}
