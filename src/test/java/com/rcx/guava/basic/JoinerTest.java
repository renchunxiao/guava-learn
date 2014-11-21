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

public class JoinerTest
{
    private List<String> strings;
    private Map<String, String> map;

    @Before
    public void before()
    {
        strings = new ArrayList<String>();
        strings.add("rcx");
        strings.add("rcx1");
        strings.add(null);
        strings.add("rcx2");

        map = Maps.newLinkedHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }

    // @Test
    public void joinerTest()
    {
        String string = Joiner.on("|").skipNulls().join(strings);
        String expected = "rcx|rcx1|rcx2";

        String string1 = Joiner.on("|").useForNull("null").join(strings);
        String expected1 = "rcx|rcx1|null|rcx2";

        assertEquals(expected, string);
        assertEquals(expected1, string1);
    }

    // @Test
    public void immutableTest()
    {
        Joiner joiner = Joiner.on("|");
        Joiner joiner2 = joiner.useForNull("aaa");
        joiner2.join(strings);
        assertNotSame(joiner, joiner2);
    }

    // @Test
    public void whitStringBuilderTest()
    {
        StringBuilder builder = new StringBuilder();
        builder = Joiner.on("|").skipNulls().appendTo(builder, strings);
        assertEquals("rcx|rcx1|rcx2", builder.toString());
    }

    /**
     * 用于查看JDK的String.split方法
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        // parts is [Monday, Tuesday, , Thursday,Friday]
        String[] parts = testString.split(",");
        System.out.println(parts.length);
        for (String string : parts)
        {
            System.out.println(string);
        }
    }

    // @Test
    public void appendableTest() throws IOException
    {
        FileWriter writer = new FileWriter("a.txt");
        Joiner joiner = Joiner.on("#").useForNull(" ");
        joiner.appendTo(writer, strings);
        writer.close();
    }

    // @Test
    public void mapJoinerTest()
    {
        String expected = "key1=value1#key2=value2#key3=value3";
        String returned = Joiner.on("#").withKeyValueSeparator("=").join(map);
        assertEquals(expected, returned);
    }

}
