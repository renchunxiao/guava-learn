package com.rcx.guava;

import java.util.Map;

import org.junit.Test;

import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

public class PreconditionsTest
{
    @Test
    public void methodTest()
    {
        String string = null;
        Preconditions.checkNotNull(string, "not null");
    }

    @Test
    public void method()
    {
        Map<String, Object> map = Maps.newHashMap();
        map.put("a", "value");
        System.out.println((String) map.get("b"));
        System.out.println("\u4e0d\u80fd\u7f3a\u5c11");
    }

}
