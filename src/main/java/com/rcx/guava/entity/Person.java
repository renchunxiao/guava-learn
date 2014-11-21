package com.rcx.guava.entity;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class Person
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this).add("age", this.age).add("name", this.name).toString();
    }
}
