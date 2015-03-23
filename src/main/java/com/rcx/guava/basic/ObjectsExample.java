package com.rcx.guava.basic;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * Objects 使用例子
 * 
 * @author chunxiao.ren created on 2015年3月23日 下午3:02:48 
 * @version 1.0
 */
public class ObjectsExample implements Comparable<ObjectsExample> {

    private String name;
    private int age;
    private String sex;

    public static void main(String[] args) {
        ObjectsExample t = new ObjectsExample();
        t.setAge(18);
        t.setName("rcx");
        t.setSex("boy");
        System.out.println(t);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age, sex);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).add("age", age).add("sex", sex).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ObjectsExample other = (ObjectsExample) obj;
        return Objects.equal(age, other.age) && Objects.equal(name, other.name) && Objects.equal(sex, other.sex);
    }

    public int compareTo(ObjectsExample o) {
        return ComparisonChain.start().compare(age, o.age).compare(name, o.name).result();
    }
}
