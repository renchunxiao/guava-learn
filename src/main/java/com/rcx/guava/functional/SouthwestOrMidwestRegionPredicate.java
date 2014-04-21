package com.rcx.guava.functional;

import com.google.common.base.Predicate;
import com.rcx.guava.entity.State;
import com.rcx.guava.enums.Region;

public class SouthwestOrMidwestRegionPredicate implements Predicate<State>
{
    public boolean apply(State input)
    {
        return input.getRegion().equals(Region.SOUTHWEST) || input.getRegion().equals(Region.MIDWEST);
    }
}