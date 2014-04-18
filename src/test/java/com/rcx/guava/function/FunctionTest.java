package com.rcx.guava.function;

import static junit.framework.Assert.assertEquals;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.rcx.guava.entity.City;
import com.rcx.guava.entity.State;

public class FunctionTest
{
    @Test
    public void applyTest()
    {
        String expected = "2014-04-18";
        DateFormateFunction formateFunction = new DateFormateFunction();
        String actual = formateFunction.apply(new Date());
        assertEquals(expected, actual);
        
        City newYorkCity1 = new City("newYork-a", "a", 350000);
        City newYorkCity2 = new City("newYork-b", "b", 350000);
        State newYork = new State("NY", "NY", Sets.newHashSet(newYorkCity1, newYorkCity2));//由于hashSet可能字符串顺序会不同
        Function<State, String> mFunction = new StateToCityStringFunction();
        assertEquals("newYork-b,newYork-a", mFunction.apply(newYork));
    }

    @Test
    public void forMapTest()
    {
        Map<String, State> stateMap = Maps.newHashMap();
        City newYorkCity1 = new City("newYork-a", "a", 350000);
        City newYorkCity2 = new City("newYork-b", "b", 350000);
        State newYork = new State("NY", "NY", Sets.newHashSet(newYorkCity1, newYorkCity2));

        City floridaCity1 = new City("florida-a", "e", 550000);
        City floridaCity2 = new City("florida-b", "c", 550000);
        State florida = new State("FD", "FD", Sets.newHashSet(floridaCity1, floridaCity2));
        stateMap.put("NY", newYork);
        stateMap.put("FD", florida);

        Function<String, State> lookup = Functions.forMap(stateMap);
        assertEquals(newYork, lookup.apply("NY"));

    }

    @Test
    public void composeTest()
    {
        Map<String, State> stateMap = Maps.newHashMap();
        City newYorkCity1 = new City("newYork-a", "a", 350000);
        City newYorkCity2 = new City("newYork-b", "b", 350000);
        State newYork = new State("NY", "NY", Sets.newHashSet(newYorkCity1, newYorkCity2));

        City floridaCity1 = new City("florida-a", "e", 550000);
        City floridaCity2 = new City("florida-b", "c", 550000);
        State florida = new State("FD", "FD", Sets.newHashSet(floridaCity1, floridaCity2));
        stateMap.put("NY", newYork);
        stateMap.put("FD", florida);

        Function<String, State> lookup = Functions.forMap(stateMap);
        Function<State, String> stateFunction = new StateToCityStringFunction();
        Function<String, String> function = Functions.compose(stateFunction, lookup);
        System.out.println(function.apply("NY"));
        assertEquals("newYork-b,newYork-a", function.apply("NY"));
    }
    
}
