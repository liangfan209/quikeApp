package com.fan.netlibrary.http;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by fanliang on 18/1/3.
 */

public abstract class BaseSubscriber<T extends BaseBean> implements Observer<T> {


    /**
     * 默认不带dialog
     */
    public BaseSubscriber() {
    }


    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        ExceptionHandle.ResponeThrowable throwable = ExceptionHandle.handleException(e);
        e.printStackTrace();
        onComplete();
    }

    @Override
    public void onNext(T t) {
        if (10000 == t.getCode()) {
            result(t);
        } else if ("-403".equals(t.getCode())) {
        } else if (30008 == t.getCode()) {

        } else if(30003 == t.getCode()){
        } else {
        }

    }

    public abstract void result(T t);


}
