package com.fan.netlibrary.http.intercepter;


import com.fan.netlibrary.http.RSA;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2018/11/23
 * 版权：
 */
public class HttpIntercepter implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        if ("POST".equals(request.method())) {
            if (request.body() instanceof FormBody) {
                FormBody.Builder bodyBuilder = new FormBody.Builder();
                FormBody formBody = (FormBody) request.body();
                StringBuilder sb = new StringBuilder();
                // 先复制原来的参数
                for (int i = 0; i < formBody.size(); i++) {
                    if (!formBody.encodedName(i).equals("file")) {
                        sb.append(formBody.encodedName(i)).append("=").append(formBody.encodedValue(i));
                        if (i != formBody.size() - 1) {
                            sb.append("&");
                        }
                    }
                    bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                }
                //继续拼接参数
                String time = String.valueOf(System.currentTimeMillis());
                String bufferStr = sb.toString() + "&platform=0&clientType=1&flag=customer&version=1&signtype=sha&protype=cs" +
                        "&timestamp=" + time;
                String unSign = RSA.getSign(bufferStr);
                System.out.println("没有加密之前字符串 unsign = " + unSign);
                //加签
                String s1 = RSA.sha1(unSign);
                String sign = RSA.sampling(s1, RSA.requestBodyStr2Map(bufferStr), 1.4);
                System.out.println("加密后 sign = " + sign);
                // 添加公共参数
                FormBody.Builder builder = bodyBuilder
                        .addEncoded("proType", "cs")
                        .addEncoded("sign", sign)
                        .addEncoded("flag", "customer")
                        .addEncoded("version", "1")
                        .addEncoded("signType", "sha")
                        .addEncoded("clientType", "1")
                        .addEncoded("platform", "0")
                        .addEncoded("timestamp", time);

                formBody = builder
                        .build();
                //将参数拼接为json,出异常的时候返回给服务器
                request = request.newBuilder().post(formBody).build();
            }
        }
        Response result = chain.proceed(request);
        return result;
    }


}
