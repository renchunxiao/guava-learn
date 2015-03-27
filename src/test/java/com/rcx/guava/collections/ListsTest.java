package com.rcx.guava.collections;

import java.util.List;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import com.google.common.collect.Lists;

/**
 * Lists 测试类
 * 
 * @author chunxiao.ren created on 2015年3月24日 上午9:45:54 
 * @version 1.0
 */
public class ListsTest {

    /**
     * 使用 newArrayList 创建 List，简化了泛型 List 的创建过程
     */
    @Test
    public void newArrayListTest() {
        List<String> list = Lists.newArrayList();
        assertEquals(0, list.size());
    }

    /**
     * 分割 list
     */
    @Test
    public void partitionTest() {
        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");

        List<List<String>> lists = Lists.partition(list, 2);

        assertEquals(3, lists.size());
    }
}
