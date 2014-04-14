package com.rcx.guava;

import org.junit.Test;

import com.google.common.base.Strings;

import static junit.framework.Assert.assertEquals;

public class StringsTest
{
    @Test
    public void padEndTest()
    {
        String originalString = "foo";
        String expectedString = "fooxxx";
        String returnString = Strings.padEnd(originalString, 6, 'x');
        assertEquals(expectedString, returnString);
        
        String returnString1 = Strings.padEnd(originalString, 2, 'x');
        assertEquals(originalString, returnString1);
    }

    @Test
    public void padStartTest()
    {
        String originalString = "foo";
        String expectedString = "xxxfoo";
        String returnString = Strings.padStart(originalString, 6, 'x');
        assertEquals(expectedString, returnString);
        
        String returnString1 = Strings.padStart(originalString, 2, 'x');
        assertEquals(originalString, returnString1);
    }

}
