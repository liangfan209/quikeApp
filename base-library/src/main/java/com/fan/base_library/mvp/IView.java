package com.fan.base_library.mvp;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public interface IView<T> {
    default void showDialog(){};
    default void dissmissDialog(){};
    default void updateView(T data){};
}