package com.rcx.guava.collections;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class Velocity
{
    public static void main(String[] args)
    {
        VelocityEngine ve = new VelocityEngine();
        
        Properties p = new Properties();
//        p.setProperty(key, value);
        
        ve.init(p);
        
//        ve.init();

        Template t = ve.getTemplate("v.vm");

        VelocityContext context = new VelocityContext();


        StringWriter writer = new StringWriter();

        t.merge(context, writer);

        System.out.println(writer.toString());

    }
}
