package com.example.java8stream;

import java.util.Arrays;
import java.util.List;

public class filterexample
{
    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Abd", "Ben" ,"KingKohli");

        for (String name : names)
        {
            if (!name.equals("Abd")) {
                System.out.println(name);
            }
        }
        System.out.println("Functional Style: ");

        names.stream().
                filter( filterexample::isNotAbd).
                forEach(System.out::println);

    }

    private static boolean isNotAbd(String name)
        {
             return  !name.equals("Abd");

       }
}
