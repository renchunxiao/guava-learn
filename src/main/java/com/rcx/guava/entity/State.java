package com.rcx.guava.entity;

import java.util.HashSet;
import java.util.Set;

public class State
{
    private String name;
    private String code;
    private Set<City> mainCities = new HashSet<City>();

    public State(String name, String code, Set<City> mainCities)
    {
        super();
        this.name = name;
        this.code = code;
        this.mainCities = mainCities;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Set<City> getMainCities()
    {
        return mainCities;
    }

    public void setMainCities(Set<City> mainCities)
    {
        this.mainCities = mainCities;
    }
}
