package com.fan.netlibrary.tcp;

import com.fan.netlibrary.NetManager;
import com.fan.netlibrary.http.JsonCallback;

import java.util.Map;

public class TcpManager extends NetManager {

    public static TcpManager getInstance(){
        return TcpHodel.mTcpManager;
    }

    @Override
    protected <T> void request(Map<String, String> map, JsonCallback<T> callback) {

    }

    private static class TcpHodel{
       private static TcpManager mTcpManager = new TcpManager();
   }
}
