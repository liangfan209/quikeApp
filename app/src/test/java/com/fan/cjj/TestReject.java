package com.fan.cjj;

import com.fan.cjj.test.TestRflex;

import java.lang.reflect.Field;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/6/1
 * 版权：
 */
public class TestReject {
    public static void main(String[] args) {
        TestRflex r = new TestRflex();
        Class reflex = TestRflex.class;
        try {
            Field filed = reflex.getDeclaredField("name");
            String aa = (String) filed.get(r);
            System.out.println(aa);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
