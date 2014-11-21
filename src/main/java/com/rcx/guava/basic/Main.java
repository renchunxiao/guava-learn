package com.rcx.guava.basic;

public class Main
{
    public static void main(String[] args) throws Throwable
    {
        try
        {
            int a = 2 / 2;
        }
        catch (RuntimeException | Error e)
        {
            throw e;
        }
    }
}
