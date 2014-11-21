package com.rcx.guava.collections;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class SetsTest
{
    @Test
    public void differenceTest()
    {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");

        System.out.println(Sets.difference(s1, s2));
        System.out.println(Sets.difference(s2, s1));
    }

    @Test
    public void symmetricDifferenceTest()
    {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");

        System.out.println(Sets.symmetricDifference(s1, s2));
    }

    @Test
    public void intersectionTest()
    {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");

        System.out.println(Sets.intersection(s1, s2));
    }
    
    @Test
    public void unionTest()
    {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");

        System.out.println(Sets.union(s1, s2));
    }
}
