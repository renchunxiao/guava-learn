package com.rcx.guava;

import org.junit.Test;

import com.google.common.base.Charsets;

public class CharsetsTest
{
    @Test
    public void method()
    {
        byte[] cs = "string".getBytes(Charsets.UTF_8);
        System.out.println(cs[0]);
    }
}
