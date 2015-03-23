package com.rcx.guava.basic;

import org.junit.Test;

/**
 * 测试 Preconditions
 * 
 * @author chunxiao.ren created on 2015年3月23日 下午2:21:12 
 * @version 1.0
 */
public class PreconditionsTest {

    /**
     * checkNotNull 测试 
     * 
     * PreconditionExample 构造器使用了 checkNotNull，如果传入 null，预期会抛出空指针异常
     */
    @Test(expected = java.lang.NullPointerException.class)
    public void checkNotNullTest() {
        new PreconditionExample(null);
    }

    /**
     * checkState 测试 
     * 
     * PreconditionExample 中 doOperation 方法，使用 checkState 判断状态，如果参数为 false 则会抛出 IllegalStateException 异常
     */
    @Test(expected = java.lang.IllegalStateException.class)
    public void checkStateTest() {
        PreconditionExample example = new PreconditionExample("lable");
        example.doOperation();
    }

    /**
     * checkArgument 测试
     * 
     * 检查传入到方法当中的参数是否非法，如果非法抛出 IllegalArgumentException 异常
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void checkArgumentTest() {
        PreconditionExample example = new PreconditionExample("open");
        example.updateCurrentIndexValue(1, 120);
    }

    /**
     * checkElementIndex 测试
     * 
     * 检查修改数组的指针索引是否越界，如果越界抛出 IndexOutOfBoundsException 异常
     */
    @Test(expected = java.lang.IndexOutOfBoundsException.class)
    public void checkElementIndexTest() {
        PreconditionExample example = new PreconditionExample("open");
        example.updateCurrentIndexValue(6, 10);
    }
}
