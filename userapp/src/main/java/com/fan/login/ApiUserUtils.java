package com.fan.login;


import com.fan.base_library.http.HttpManager;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class ApiUserUtils {
    public static ApiUserService getApiService(){
        return HttpManager.getInstance().getApi(ApiUserService.class);
    }
}
