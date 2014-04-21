package com.rcx.guava.entity;

import java.util.HashSet;
import java.util.Set;

import com.rcx.guava.enums.Region;

public class State
{
    private String name;
    private String code;
    private Set<City> mainCities = new HashSet<City>();
    private Region region;

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

    public Region getRegion()
    {
        return region;
    }

    public void setRegion(Region region)
    {
        this.region = region;
    }
}
