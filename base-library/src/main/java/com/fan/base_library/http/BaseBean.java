package com.fan.base_library.http;

import java.io.Serializable;

/**
 * Created by fanliang on 18/1/3.
 */

public class BaseBean<T> implements Serializable {
    /*版本说明*/
    private int code;
    /*回馈消息*/
    private String msg;

    private T result;


    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
