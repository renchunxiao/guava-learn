package com.rcx.guava.collections;

import java.util.Map;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import com.google.common.collect.Maps;

/**
 * Maps 测试类
 * 
 * @author chunxiao.ren created on 2015年3月27日 下午2:41:03 
 * @version 1.0
 */
public class MapsTest {

    @Test
    public void newMapsTest() {
        Map<String,String> map = Maps.newHashMap();
        assertEquals(0, map.size());
    }
}
