package com.fan.cjj;

import com.fan.base_library.config.BaseApplicationConfig;
import com.fan.cjj.http.ApiService;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class AppApplicationConfig extends BaseApplicationConfig {

    public AppApplicationConfig() {
        this.baseUrl = "http://39.108.101.173:8001";
        this.service = ApiService.class;
    }
}
