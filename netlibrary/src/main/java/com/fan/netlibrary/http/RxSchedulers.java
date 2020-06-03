package com.fan.netlibrary.http;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 主线程切换
 */
public class RxSchedulers {

    public static <T> ObservableTransformer<T, T> io_main() {
//        return upstream ->
//                upstream.subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread());


        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {

                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
