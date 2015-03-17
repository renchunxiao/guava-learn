package com.rcx.guava.basic;

import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.google.common.base.Charsets;

/**
 * Charsets 是一个常量工厂，给出了 6 个 Java 承诺了全平台支持的字符集
 * 
 * @author chunxiao.ren created on 2015年3月17日 上午11:33:43 
 * @version 1.0
 */
public class CharsetsTest {

    /**
     * 在 JDK 7 当中有个 StandardCharsets 类与 Charsets 的作用是一样的可以使用
     */
    @Test
    public void test() {
        byte[] cs = "string".getBytes(Charsets.UTF_8);
        byte[] cs1 = "string".getBytes(StandardCharsets.UTF_8);
        System.out.println(cs[0]);
        System.out.println(cs1[0]);
    }
}
