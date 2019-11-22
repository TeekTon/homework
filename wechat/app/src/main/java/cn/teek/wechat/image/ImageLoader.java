package cn.teek.wechat.image;

import android.widget.ImageView;

import cn.teek.wechat.R;

/**
 * 要加载的图片内容
 */
public class ImageLoader {
    private int type;  //类型 (大图，中图，小图)
    private String url; //需要解析的 url
    private int placeHolder; //当没有成功加载的时候显示的图片
    private ImageView ImageView; //ImageView 的实例
    private int wifiStrategy;//加载策略，是否在 wifi 下才加载

    private ImageLoader(Builder builder) {
        this.type = builder.type;
        this.url = builder.url;
        this.placeHolder = builder.placeHolder;
        this.ImageView = builder.imageView;
        this.wifiStrategy = builder.wifiStrategy;
    }

    public int getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public ImageView getImageView() {
        return ImageView;
    }

    public int getWifiStrategy() {
        return wifiStrategy;
    }

    public static class Builder {
        private int type;  //类型 (大图，中图，小图)
        private String url; //需要解析的url
        private int placeHolder; //当没有成功加载的时候显示的图片
        private ImageView imageView; //ImageView
        private int wifiStrategy;//加载策略，是否在wifi下才载

        public Builder() {
            this.type = ImageLoaderUtils.PIC_SMALL;
            this.url = "";
            this.placeHolder = R.mipmap.ic_launcher;
            this.imageView = null;
            this.wifiStrategy = ImageLoaderUtils.LOAD_STRATEGY_NORMAL;
        }

        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder placeHolder(int placeHolder) {
            this.placeHolder = placeHolder;
            return this;
        }

        public Builder imageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public Builder wifiStrategy(int wifiStrategy) {
            this.wifiStrategy = wifiStrategy;
            return this;
        }

        public ImageLoader bulid() {
            return new ImageLoader(this);
        }
    }
}
