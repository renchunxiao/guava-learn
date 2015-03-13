package com.rcx.guava.basic;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

/**
 * Joiner 测试类
 * 
 * @author chunxiao.ren created on 2015年3月13日 下午2:41:56 
 * @version 1.0
 */
public class JoinerTest
{
    private List<String> list;
    private Map<String, String> map;

    @Before
    public void before()
    {
        list = new ArrayList<String>();
        list.add("rcx");
        list.add("rcx1");
        list.add(null);
        list.add("rcx2");

        map = Maps.newLinkedHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }

    // @Test
    /**
     * 测试普通 join 功能
     */
    public void joinerTest()
    {
        String string = Joiner.on("|").skipNulls().join(list);
        String expected = "rcx|rcx1|rcx2";

        String string1 = Joiner.on("|").useForNull("null").join(list);
        String expected1 = "rcx|rcx1|null|rcx2";

        assertEquals(expected, string);
        assertEquals(expected1, string1);
    }

    // @Test
    /**
     * 测试 Joiner 是不可变类
     */
    public void immutableTest()
    {
        Joiner joiner = Joiner.on("|");
        Joiner joiner2 = joiner.useForNull("aaa");
        joiner2.join(list);
        assertNotSame(joiner, joiner2);
    }

    // @Test
    /**
     * 测试 Joiner 输出到 StringBuilder 中
     */
    public void whitStringBuilderTest()
    {
        StringBuilder builder = new StringBuilder();
        builder = Joiner.on("|").skipNulls().appendTo(builder, list);
        assertEquals("rcx|rcx1|rcx2", builder.toString());
    }

    // @Test
    /**
     * 测试将 appendTo 结果输出到文件
     * 
     * @throws IOException
     */
    public void appendableTest() throws IOException
    {
        FileWriter writer = new FileWriter("a.txt");
        Joiner joiner = Joiner.on("#").useForNull(" ");
        joiner.appendTo(writer, list);
        writer.close();
    }

    // @Test
    /**
     * 测试对 map 的 join 功能
     */
    public void mapJoinerTest()
    {
        String expected = "key1=value1#key2=value2#key3=value3";
        String returned = Joiner.on("#").withKeyValueSeparator("=").join(map);
        assertEquals(expected, returned);
    }

}
