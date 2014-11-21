package com.rcx.guava.collections;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.rcx.guava.entity.Person;

public class FluentIterableTest
{
    private List<Person> persons = new ArrayList<Person>();

    @Before
    public void before()
    {
        persons.add(new Person("rcx1", 19));
        persons.add(new Person("rcx2", 20));
        persons.add(new Person("rcx3", 21));
        persons.add(new Person("rcx4", 22));
    }

    @Test
    public void testFilter()
    {
        Iterable<Person> iterable = FluentIterable.from(persons).filter(new Predicate<Person>()
        {
            @Override
            public boolean apply(Person person)
            {
                if (person.getAge() > 20)
                {
                    return true;
                }
                return false;
            }
        });

        for (Person p : iterable)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testTransform()
    {
        List<String> strings = (List<String>) FluentIterable.from(persons)
                .transform(new Function<Person, String>()
                {
                    @Override
                    public String apply(Person input)
                    {
                        return Joiner.on("#").join(input.getAge(), input.getName()).toString();
                    }
                }).toList();

        System.out.println(strings);
    }

}
