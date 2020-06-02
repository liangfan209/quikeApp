package com.fan.cjj.http;

import com.fan.base_library.http.BaseBean;
import com.fan.login.bean.LoginInfo;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public interface ApiService {

    //登录
    @POST("/interface")
    @FormUrlEncoded
    Observable<BaseBean<LoginInfo>> hhrLogin(@Field("api") String api,
                                             @Field("username") String username,
                                             @Field("password") String password);

    //忘记密码
    @POST("/interface")
    @FormUrlEncoded
    Observable<BaseBean> hhrForgetPwd(@Field("api") String api,
                                                 @Field("newpassword") String username,
                                                 @Field("phone") String password,
                                                 @Field("checkCode") String checkCode);
    //获取手机验证码
    @POST("/interface")
    @FormUrlEncoded
    Observable<BaseBean> hhrGetVertificatCode(@Field("api") String api,
                                      @Field("type") String type,
                                      @Field("phone") String phone);
}
