package com.fan.base_library;

import android.app.Application;

import com.fan.base_library.config.BaseApplicationConfig;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class BaseApplication extends Application {
    public static BaseApplication baseApplication;
    public static BaseApplicationConfig baseApplicationConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public <T> T parseClass(String name) {
        try {
            Class<?> aClass = Class.forName(name);
            Object o = aClass.newInstance();
            return (T) o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
