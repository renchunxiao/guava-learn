package com.rcx.guava.collections;

import java.util.HashMap;

import com.google.common.base.Objects;
import com.google.common.collect.Collections2;
import com.google.common.collect.ComparisonChain;


public class T implements Comparable<T>
{
    private String name;
    private int age;
    private String sex;
        
    public static void main(String[] args)
    {
        T t = new T();
        t.setAge(18);
        t.setName("rcx");
        t.setSex("boy");
        System.out.println(t);
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this).add("name", name).add("age", age).add("sex", sex).toString();
//        return "T [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        T other = (T) obj;
        return Objects.equal(age, other.age) && Objects.equal(name, other.name) && Objects.equal(sex, other.sex);
    }
//    public boolean equals(Object obj)
//    {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        T other = (T) obj;
//        if (age != other.age)
//            return false;
//        if (name == null)
//        {
//            if (other.name != null)
//                return false;
//        }
//        else if (!name.equals(other.name))
//            return false;
//        if (sex == null)
//        {
//            if (other.sex != null)
//                return false;
//        }
//        else if (!sex.equals(other.sex))
//            return false;
//        return true;
//    }

    public int compareTo(T o)
    {
        return ComparisonChain.start().compare(age, o.age).compare(name, o.name).result();
    }
}
