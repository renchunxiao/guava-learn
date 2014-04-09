package com.rcx.guava;

import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.*;
import org.junit.Test;
import com.google.common.base.Joiner;

public class JoinerTest
{
    @Test
    public void method1()
    {
        List<String> strings = new ArrayList<String>();
        strings.add("rcx");
        strings.add("rcx1");
        strings.add("rcx2");
        String string = Joiner.on("|").skipNulls().join(strings);
        assertEquals("rcx|rcx1|rcx2", string);
    }
}
