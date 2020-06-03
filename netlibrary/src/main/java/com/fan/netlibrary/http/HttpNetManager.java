package com.fan.netlibrary.http;

import com.fan.netlibrary.NetManager;
import com.lzy.okgo.OkGo;

import java.util.Map;

public class HttpNetManager extends NetManager {

    public static HttpNetManager getInstance() {
        return NetHolder.sHttpNetManager;
    }

    @Override
    protected <T> void request(Map<String, String> map, JsonCallback<T> callback) {
        OkGo.<T>post("")
                .params(map)
                .execute(callback);
    }

    private static class NetHolder {
        private static HttpNetManager sHttpNetManager = new HttpNetManager();
    }

}