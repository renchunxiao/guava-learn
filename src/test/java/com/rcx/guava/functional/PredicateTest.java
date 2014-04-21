package com.rcx.guava.functional;

import java.util.Map;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.rcx.guava.entity.City;
import com.rcx.guava.entity.State;
import com.rcx.guava.enums.Region;
import com.rcx.guava.functional.PopulationPredicate;

public class PredicateTest
{
    @Test
    public void appltTest()
    {
        City city = new City("beijing", "bj", 20000000);
        Predicate<City> populationPredicate = new PopulationPredicate();
        assertEquals(false, populationPredicate.apply(city));
    }

    @Test
    public void andTest()
    {
        City city1 = new City("beijing", "bj", 20000000);
        city1.setAverageRainfall(35);
        Predicate<City> smallPopulationPredicate = new PopulationPredicate();
        Predicate<City> lowRainFallPredicate = new LowRainfallPredicate();
        Predicate<City> and = Predicates.and(smallPopulationPredicate, lowRainFallPredicate);
        assertEquals(false, and.apply(city1));

        City city2s = new City("shenyang", "bj", 200000);
        city1.setAverageRainfall(35);
        assertEquals(true, and.apply(city2s));
    }

    @Test
    public void orTest()
    {
        City city1 = new City("beijing", "bj", 20000000);
        city1.setAverageRainfall(35);
        Predicate<City> smallPopulationPredicate = new PopulationPredicate();
        Predicate<City> lowRainFallPredicate = new LowRainfallPredicate();
        Predicate<City> or = Predicates.or(smallPopulationPredicate, lowRainFallPredicate);
        assertEquals(true, or.apply(city1));

        City city2s = new City("shenyang", "bj", 200000);
        city1.setAverageRainfall(35);
        assertEquals(true, or.apply(city2s));
    }

    @Test
    public void notTest()
    {
        Predicate<City> smallPopulationPredicate = new PopulationPredicate();
        Predicate<City> largeCityPredicate = Predicates.not(smallPopulationPredicate);
        City city1 = new City("beijing", "bj", 20000000);

        assertEquals(true, largeCityPredicate.apply(city1));
    }

    @Test
    public void composeTest()
    {
        Predicate<State> southwestOrMidwestRegionPredicate = new SouthwestOrMidwestRegionPredicate();
        Map<String, State> stateMap = Maps.newHashMap();
        City newYorkCity1 = new City("newYork-a", "a", 350000);
        City newYorkCity2 = new City("newYork-b", "b", 350000);
        State newYork = new State("NY", "NY", Sets.newHashSet(newYorkCity1, newYorkCity2));
        newYork.setRegion(Region.EAST);

        City floridaCity1 = new City("florida-a", "e", 550000);
        City floridaCity2 = new City("florida-b", "c", 550000);
        State florida = new State("FD", "FD", Sets.newHashSet(floridaCity1, floridaCity2));
        stateMap.put("NY", newYork);
        stateMap.put("FD", florida);
        florida.setRegion(Region.SOUTHWEST);

        Function<String, State> lookup = Functions.forMap(stateMap);
        Predicate<String> predicate = Predicates.compose(southwestOrMidwestRegionPredicate, lookup);

        assertEquals(false, predicate.apply("NY"));
        assertEquals(true, predicate.apply("NY"));
    }
}
