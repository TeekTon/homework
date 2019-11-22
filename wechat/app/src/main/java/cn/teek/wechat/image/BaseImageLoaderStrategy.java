package cn.teek.wechat.image;

import android.content.Context;

/**
 * 图片加载接口类,定义图片加载接口，供子类实现
 */
public interface BaseImageLoaderStrategy {
    void loadImage(Context context,ImageLoader imageLoader);
}
