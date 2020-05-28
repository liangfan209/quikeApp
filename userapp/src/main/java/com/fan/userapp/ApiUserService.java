package com.fan.userapp;

import com.fan.base_library.http.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28/028
 * 版权：
 */
public interface ApiUserService {

    //获取用户
    @POST("/interface")
    @FormUrlEncoded
    Observable<BaseBean> hhrLogin(@Field("api") String api,
                                  @Field("username") String username,
                                  @Field("password") String password);
}
