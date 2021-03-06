package com.fan.cjj;

import com.fan.cjj.test.TestRflex;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test(){
        TestRflex r = new TestRflex();
        Class reflex = TestRflex.class;
        try {
            Field filed = reflex.getDeclaredField("name");
            filed.setAccessible(true);
            String aa = (String) filed.get(r);
            System.out.println(aa);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}