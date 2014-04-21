package com.rcx.guava.entity;

import com.rcx.guava.enums.Climate;

public class City
{
    private String name;
    private String zipCode;
    /** 人口 */
    private int population;
    private Climate climate;
    private int averageRainfall;

    public String getName()
    {
        return name;
    }

    public City(String name, String zipCode, int population)
    {
        super();
        this.name = name;
        this.zipCode = zipCode;
        this.population = population;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }

    public Climate getClimate()
    {
        return climate;
    }

    public void setClimate(Climate climate)
    {
        this.climate = climate;
    }

    public int getAverageRainfall()
    {
        return averageRainfall;
    }

    public void setAverageRainfall(int averageRainfall)
    {
        this.averageRainfall = averageRainfall;
    }
}
