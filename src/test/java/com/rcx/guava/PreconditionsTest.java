package com.rcx.guava;

import org.junit.Test;

import com.google.common.base.Preconditions;

public class PreconditionsTest
{
    @Test
    public void methodTest()
    {
        String string = null;
        Preconditions.checkNotNull(string, "not null");
    }
}
