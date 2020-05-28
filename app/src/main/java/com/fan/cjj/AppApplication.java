package com.fan.cjj;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.fan.base_library.BaseApplication;

import java.util.Set;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //反射manafest文件
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getPackageManager().getApplicationInfo(getPackageName(),
                    PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Set<String> strings = applicationInfo.metaData.keySet();
        for (String key: strings) {
            if("test".equals(applicationInfo.metaData.get(key))){
                baseApplicationConfig = parseClass(key);
            }
        }
    }
}
