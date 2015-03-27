package com.rcx.guava.collections;

import static junit.framework.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * Sets 测试类
 * 
 * @author chunxiao.ren created on 2015年3月27日 下午2:41:36 
 * @version 1.0
 */
public class SetsTest {

    @Test
    public void newSetTest() {
        Set<String> set = Sets.newHashSet();
        assertEquals(0, set.size());
    }

    /**
     * 查找在第一个 set 当中，但是不在第二个 set 当中的元素
     */
    @Test
    public void differenceTest() {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");

        System.out.println(Sets.difference(s1, s2));
        System.out.println(Sets.difference(s2, s1));
    }

    /**
     * 查找不在两个 set 当中都存在的元素
     */
    @Test
    public void symmetricDifferenceTest() {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");

        System.out.println(Sets.symmetricDifference(s1, s2));
    }

    /**
     * 查找在两个 set 当中都存在的元素
     */
    @Test
    public void intersectionTest() {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");

        System.out.println(Sets.intersection(s1, s2));
    }

    /**
     * 两个集合的交集
     */
    @Test
    public void unionTest() {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");

        System.out.println(Sets.union(s1, s2));
    }
}
