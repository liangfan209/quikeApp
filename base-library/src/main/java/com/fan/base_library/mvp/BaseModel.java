package com.fan.base_library.mvp;

import com.fan.base_library.http.RxSchedulers;

import java.io.Serializable;

import io.reactivex.Observable;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class BaseModel implements Serializable {
    public <T> Observable<T> exeHttp(Observable<T> observable) {
        return observable.compose(RxSchedulers.<T>io_main());
    }
}
