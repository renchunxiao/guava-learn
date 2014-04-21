package com.rcx.guava.functional;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.rcx.guava.entity.State;

public class StateToCityStringFunction implements Function<State, String>
{
    public String apply(State input)
    {
        return Joiner.on(",").join(input.getMainCities()).toString();
    }
}
