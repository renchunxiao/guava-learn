package com.rcx.guava.entity;

public class City
{
    private String name;
    private String zipCode;
    /** 人口 */
    private int population;

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
}
