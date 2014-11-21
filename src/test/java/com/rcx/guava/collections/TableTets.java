package com.rcx.guava.collections;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

public class TableTets
{
    @Test
    public void method()
    {
        Map<String, String> map = Maps.newHashMap();
        map.put("key", "value");
        map.put("key1", "value1");
        map.put("key2", "value2");
        
        
        map = Maps.transformEntries(map,new EntryTransformer<String, String, String>()
        {
            public String transformEntry(String key, String value)
            {
                if("key1".equals(key)) {
                    return "asd";
                }
                return value;
            }
        });
        
        System.err.println(map);
    }
}
