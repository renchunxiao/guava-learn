package com.rcx.guava;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter.MapSplitter;
import com.google.common.collect.Maps;

import static junit.framework.Assert.assertEquals;

public class SplitterTest
{
    @Test
    public void splitTest()
    {
        List<String> strings = Splitter.on('|').splitToList("foo|bar|baz|||");
        System.out.println(strings.size());
    }

    @Test
    public void mapSplitterTest()
    {
        Map<String, String> expectedMap = Maps.newLinkedHashMap();
        expectedMap.put("key1", "value1");
        expectedMap.put("key2", "value2");
        
        MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> returnMap = mapSplitter.split("key1=value1#key2=value2");
        
        assertEquals(expectedMap, returnMap);
    }

}
