package cn.teek.wechat.image;

import android.content.Context;
import android.widget.ImageView;

/**
 * 图片加载框架 策略模式
 * <p>
 * 设计为单例模式，并且暴露一个方法，可以设置加载模式，使用哪种图片加载框架。
 */

public class ImageLoaderUtils {
    //图片类型
    public static final int PIC_LARGE = 0;//大图
    public static final int PIC_MEDIUM = 1;//中图
    public static final int PIC_SMALL = 2;//小图
    //是否在 WIFI 下加载
    public static final int LOAD_STRATEGY_NORMAL = 0;
    public static final int LOAD_STRATEGY_ONLY_WIFI = 1;


    private static ImageLoaderUtils mInstance;

    private BaseImageLoaderStrategy imageLoaderStrategy;

    private ImageLoaderUtils() {
        //默认使用 Glide 加载模式
        imageLoaderStrategy = new GlideImageLoaderStrategy();

    }

    public static ImageLoaderUtils getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoaderUtils.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderUtils();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    /**
     * 设置使用的图片加载框架
     *
     * @param imageLoaderStrategy
     */
    public void setImageLoaderStrategy(BaseImageLoaderStrategy imageLoaderStrategy) {

        this.imageLoaderStrategy = imageLoaderStrategy;
    }

    /**
     * 加载图片
     *
     * @param context
     * @param imageLoader
     */
    public void loadImage(Context context, ImageLoader imageLoader) {
        imageLoaderStrategy.loadImage(context, imageLoader);
    }

    /**
     * @param context   context
     * @param path      图片路径uri
     * @param imageView 控件
     */
    public void loadImage(Context context, String path, ImageView imageView) {
        //由于http无法使用所以转为https
        path = path.replace("http", "https");
        ImageLoader imageLoader =
                new ImageLoader.Builder()
                        .url(path)
                        .imageView(imageView)
                        .bulid();
        imageLoaderStrategy.loadImage(context, imageLoader);
    }
}