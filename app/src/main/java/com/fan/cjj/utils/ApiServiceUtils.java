package com.fan.cjj.utils;

import com.fan.base_library.http.HttpManager;
import com.fan.cjj.http.ApiService;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class ApiServiceUtils {
    public static ApiService getApiService(){
        return HttpManager.getInstance().getApi(ApiService.class);
    }
}
