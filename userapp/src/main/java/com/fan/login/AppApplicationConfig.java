package com.fan.login;

import com.fan.base_library.config.BaseApplicationConfig;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class AppApplicationConfig extends BaseApplicationConfig {

    public AppApplicationConfig() {
        this.baseUrl = "http://192.168.3.213:8769";
        this.service = ApiUserUtils.class;
    }
}
