package com.rcx.guava;

import org.joda.time.DateTime;
import org.junit.Test;

public class JodaTimeTest
{
    @Test
    public void method()
    {
        DateTime now = new DateTime();
        int hour = now.getHourOfDay();
        if (hour < 13) {
            String[] arriveTimes = {"14:00", "15:00", "16:00", "17:00", "18:00及之后"};
            for(String string : arriveTimes) {
                System.out.print(string + ", ");
            }
        } else {//TODO +1后推4小时
            int min = now.getMinuteOfHour();
            if (min < 30) {
                String[] arriveTimes = {(hour + 1) + ":00", (hour + 2) + ":00", (hour + 3) + ":00", (hour + 4) + ":00", (hour + 5) + ":00及之后"};
                for(String string : arriveTimes) {
                    System.out.print(string + ", ");
                }
            } else {
                String[] arriveTimes = {(hour + 2) + ":00", (hour + 3) + ":00", (hour + 4) + ":00", (hour + 5) + ":00", (hour + 6) + ":00及之后"};
                for(String string : arriveTimes) {
                    System.out.print(string + ", ");
                }
            }
        }
    }
    
}
