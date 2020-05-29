package com.fan.cjj.test;

import java.io.Serializable;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/29
 * 版权：
 */
public class TestObject implements Serializable {

    public TestObject(String str) {
        this.str = str;
    }

    public String str;
}
