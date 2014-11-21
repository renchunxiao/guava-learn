package com.rcx.guava.basic;

import org.junit.Test;

import com.google.common.base.Strings;

import static junit.framework.Assert.assertEquals;

public class StringsTest
{
    @Test
    public void padEndTest()
    {
        String original = "foo";
        String expected = "fooxxx";
        String returnString = Strings.padEnd(original, 6, 'x');
        assertEquals(expected, returnString);

        String returnString1 = Strings.padEnd(original, 2, 'x');
        assertEquals(original, returnString1);
    }

    @Test
    public void padStartTest()
    {
        String original = "foo";
        String expected = "xxxfoo";
        String returnString = Strings.padStart(original, 6, 'x');
        assertEquals(expected, returnString);

        String returnString1 = Strings.padStart(original, 2, 'x');
        assertEquals(original, returnString1);
    }

    @Test
    public void empetyTest()
    {
        String empety = "";
        assertEquals(null, Strings.emptyToNull(empety));
        assertEquals(true, Strings.isNullOrEmpty(empety));
        assertEquals(empety, Strings.nullToEmpty(null));
    }
}
