package com.rcx.guava.functional;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

public class SupplierTest
{
    @Test
    public void getTest()
    {
        Supplier<Predicate<String>> supplier = new ComposedPredicateSupplier();
        Predicate<String> predicate = supplier.get();
        assertEquals(false, predicate.apply("NY"));
    }
    
    @Test
    public void memoizeTest()
    {
        Supplier<Predicate<String>> supplier = new ComposedPredicateSupplier();
        Supplier<Predicate<String>> wrapped = Suppliers.memoize(supplier);
        assertEquals(wrapped.get(), wrapped.get());
    }
    
    @Test
    public void memoizeWithExpirationTest() throws Exception
    {
        Supplier<Predicate<String>> supplier = new ComposedPredicateSupplier();
        Supplier<Predicate<String>> wrapped = Suppliers.memoizeWithExpiration(supplier, 5, TimeUnit.SECONDS);
        Predicate<String> predicate1 = wrapped.get();
        Thread.sleep(8000);
        Predicate<String> predicate2 = wrapped.get();
        assertEquals(predicate1, predicate2);
    }
}
