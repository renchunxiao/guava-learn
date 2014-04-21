package com.rcx.guava.functional;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.rcx.guava.entity.City;
import com.rcx.guava.entity.State;
import com.rcx.guava.enums.Region;

public class ComposedPredicateSupplier implements Supplier<Predicate<String>>
{
    public Predicate<String> get()
    {
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
        return Predicates.compose(new SouthwestOrMidwestRegionPredicate(), lookup);
    }

}