package cn.teek.wechat.network.api;

import java.util.List;

import cn.teek.wechat.data.bean.TweetBean;
import cn.teek.wechat.data.bean.UserInfoBean;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 服务端接口
 */
public interface CommonApi {
    //对应服务端的url
    String BASE_URL = "https://thoughtworks-ios.herokuapp.com";

    //获取指定用户信息
    @GET("/user/{name}")
    Single<UserInfoBean> getUserInfo(@Path("name") String name);

    //获取指定用户tweets
    @GET("user/{name}/tweets")
    Single<List<TweetBean>> getUserTweets(@Path("name") String name);
}
