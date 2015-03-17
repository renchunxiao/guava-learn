package com.rcx.guava.basic;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.Strings;

/**
 * 操作 String 或者 CharSequence 的静态方法工具类
 * 
 * @author chunxiao.ren created on 2015年3月17日 上午11:35:31 
 * @version 1.0
 */
public class StringsTest {

    /**
     * 在字符串后面填充字符
     * Strings.padEnd(String string, int minLength, char padChar) 需要 3 个参数
     * string 为需要填充的字符串
     * minLength 为填充后的长度，如果长度小于 string 的长度，则直接返回 string
     * padChar 填充到后面的字符
     */
    @Test
    public void padEndTest() {
        String original = "foo";
        String expected = "fooxxx";
        String returnString = Strings.padEnd(original, 6, 'x');
        assertEquals(expected, returnString);

        String returnString1 = Strings.padEnd(original, 2, 'x');
        assertEquals(original, returnString1);
    }

    /**
     * 在字符串前面填充字符
     * 参数与 padEnd 方法类似
     */
    @Test
    public void padStartTest() {
        String original = "foo";
        String expected = "xxxfoo";
        String returnString = Strings.padStart(original, 6, 'x');
        assertEquals(expected, returnString);

        String returnString1 = Strings.padStart(original, 2, 'x');
        assertEquals(original, returnString1);
    }

    /**
     * 将指定的字符串重复 n 次
     */
    @Test
    public void repeatTest() {
        String original = "foo";
        String expected = "foofoofoo";
        String actual = Strings.repeat(original, 3);
        assertEquals(expected, actual);
    }

    /**
     * 查找两个字符串相同的前缀或相同的后缀
     */
    @Test
    public void commonPrefixAndcommonSuffixTest() {
        String s1 = "asdfg";
        String s2 = "asdde";
        String s3 = "fgasd";
        String s4 = "deasd";
        String expected = "asd";
        assertEquals(expected, Strings.commonPrefix(s1, s2));
        assertEquals(expected, Strings.commonSuffix(s3, s4));
    }

    /**
     * 处理空串
     */
    @Test
    public void empetyTest() {
        String empety = "";
        assertEquals(null, Strings.emptyToNull(empety));
        assertEquals(true, Strings.isNullOrEmpty(empety));
        assertEquals(empety, Strings.nullToEmpty(null));
    }
}
