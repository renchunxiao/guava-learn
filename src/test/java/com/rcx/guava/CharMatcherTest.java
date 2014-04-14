package com.rcx.guava;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import com.google.common.base.CharMatcher;

public class CharMatcherTest
{
    @Test
    public void breakingWhitespaceTest()
    {
        String original = "asdasd \nasd\rasd";
        String expected = "asdasd  asd asd";
        String actual = CharMatcher.BREAKING_WHITESPACE.replaceFrom(original, ' ');

        assertEquals(expected, actual);
    }

    @Test
    public void removeWhiteSpaceTest()
    {
        String tabsAndSpaces = "String with spaces and      tabs";
        String expected = "String with spaces and tabs";
        String actual = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        assertEquals(expected, actual);
    }

    @Test
    public void trimRemoveWhiteSpaceTest()
    {
        String tabsAndSpaces = " String with spaces and            tabs";
        String expected = "String with spaces and tabs";
        String actual = CharMatcher.WHITESPACE.trimAndCollapseFrom(tabsAndSpaces, ' ');
        assertEquals(expected, actual);
    }

    @Test
    public void retainFromTest()
    {
        String lettersAndNumbers = "foo989yxbar234";
        String expected = "989234";
        String actual = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        assertEquals(expected, actual);
    }
}
