package com.rcx.guava.basic;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter.MapSplitter;
import com.google.common.collect.Maps;

/**
 * 
 * Splitter 测试类
 * 
 * @author chunxiao.ren created on 2015年3月13日 下午6:54:07 
 * @version 1.0
 */
public class SplitterTest {

    private List<String> list;

    @Before
    public void before() {
        list = new ArrayList<String>();
        list.add(" foo");
        list.add("bar");
        list.add("baz");
        list.add("");
        list.add("");
        list.add(" ");
    }

    /**
     * 测试字符串分割成 Iterable
     */
    @Test
    public void splitTest() {
        List<String> strings = Splitter.on('|').splitToList(" foo|bar|baz||| ");
        Iterable<String> iterable = Splitter.on('|').trimResults().split(" foo | bar | baz | | |");
        assertEquals(list, strings);
        System.out.println(iterable);
    }

    /**
     * 测试字符串分割成 Map
     */
    @Test
    public void mapSplitterTest() {
        Map<String,String> expectedMap = Maps.newLinkedHashMap();
        expectedMap.put("key1", "value1");
        expectedMap.put("key2", "value2");

        MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String,String> returnMap = mapSplitter.split("key1=value1#key2=value2");

        assertEquals(expectedMap, returnMap);
    }

}
