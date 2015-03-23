package com.rcx.guava.basic;

import static com.google.common.base.Preconditions.*;

/**
 * Precondition 使用例子
 * 
 * @author chunxiao.ren created on 2015年3月23日 下午2:16:28 
 * @version 1.0
 */
public class PreconditionExample {
    private String label;
    private int[] values = new int[5];
    private int currentIndex;

    public PreconditionExample(String label) {
        this.label = checkNotNull(label, "Label can''t be null");
    }

    public void updateCurrentIndexValue(int index, int valueToSet) {
        this.currentIndex = checkElementIndex(index, values.length, "Index out of bounds for values");
        checkArgument(valueToSet <= 100, "Value can't be more than100");
        values[this.currentIndex] = valueToSet;
    }

    public void doOperation() {
        checkState(validateObjectState(), "Can't perform operation");
    }

    private boolean validateObjectState() {
        return this.label.equalsIgnoreCase("open") && values[this.currentIndex] == 10;
    }
}