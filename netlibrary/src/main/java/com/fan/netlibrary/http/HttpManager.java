package com.fan.netlibrary.http;


import com.fan.netlibrary.http.intercepter.HttpIntercepter;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class HttpManager {

    public static final int TIME_OUT = 60;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private Object api;
    private static HttpManager mInstance;
    public static HttpManager getInstance(){
        if(mInstance == null){
            synchronized (HttpManager.class){
                if(mInstance == null){
                    mInstance = new HttpManager();
                }
            }
        }
        return mInstance;
    }

    public <T>T getApi(Class<T> c) {
        if (api == null) {
            api = retrofit.create(c);
        }
        return (T)api;
    }

    private HttpManager() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder()
//                    .proxy(Proxy.NO_PROXY)
                    .addInterceptor(logging)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(new HttpIntercepter())
                    .sslSocketFactory(createSSLSocketFactory())
                    .build();
        }
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseApplication.baseApplicationConfig.baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 添加Rx适配器
                    .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                    .client(okHttpClient)
                    .build();
    }


    private SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            MyTrustManager mMyTrustManager = new MyTrustManager();
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{mMyTrustManager}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        return ssfFactory;
    }
}
