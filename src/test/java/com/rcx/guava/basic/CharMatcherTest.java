package com.rcx.guava.basic;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * CharMatcher 是用于字符匹配
 * 
 * @author chunxiao.ren created on 2015年3月19日 下午2:19:05 
 * @version 1.0
 */
public class CharMatcherTest {
    /**
     * 将多行的字符串格式化成一行，并且换行符将会以空格来代替。
     */
    @Test
    public void breakingWhitespaceTest() {
        String original = "asdasd \nasd\rasd";
        String expected = "asdasd  asd asd";
        String actual = CharMatcher.BREAKING_WHITESPACE.replaceFrom(original, ' ');

        assertEquals(expected, actual);
    }

    /**
     * 把一组连续的匹配字符替换成一个字符
     */
    @Test
    public void removeWhiteSpaceTest() {
        String tabsAndSpaces = "String with spaces and          tabs";
        String expected = "String with spaces and tabs";
        String actual = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        assertEquals(expected, actual);
    }

    /**
     * 先对字符串进行 trim 后进行匹配
     */
    @Test
    public void trimRemoveWhiteSpaceTest() {
        String tabsAndSpaces = " String with spaces and            tabs";
        String expected = "String with spaces and tabs";
        String actual = CharMatcher.WHITESPACE.trimAndCollapseFrom(tabsAndSpaces, ' ');
        assertEquals(expected, actual);
    }

    /**
     * 将匹配的字符串保留下来
     */
    @Test
    public void retainFromTest() {
        String lettersAndNumbers = "foo989yxbar234";
        String expected = "989234";
        String actual = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        assertEquals(expected, actual);
    }

    /**
     * CharMatcher.is() 方法返回一个匹配指定字符的 CharMatcher 对象
     */
    @Test
    public void isTest() {
        String string = "this is a big test";
        String expected = "thi- i- a big te-t";
        String actual = CharMatcher.is('s').replaceFrom(string, '-');
        assertEquals(expected, actual);
    }

    /**
     * CharMatcher 中判定型函数，判断 CharMacher 和入参字符串的匹配关系。
     */
    @Test
    public void matchesTest() {
        assertEquals(true, CharMatcher.is('a').matchesAllOf("aaa"));
        assertEquals(true, CharMatcher.is('a').matchesAnyOf("aba"));
        assertEquals(false, CharMatcher.is('a').matchesNoneOf("aba"));
    }

    /**
     * CharMatcher 中计数型函数，查找入参字符串中第一次、最后一次出现目标字符的位置，或者目标字符出现的次数
     */
    @Test
    public void indexTest() {
        String string = "this is a big test";
        assertEquals(8, CharMatcher.is('a').indexIn(string));
        assertEquals(6, CharMatcher.is('s').indexIn(string, 5));
        assertEquals(16, CharMatcher.is('s').lastIndexIn(string));
        assertEquals(3, CharMatcher.is('s').countIn(string));
    }
}
