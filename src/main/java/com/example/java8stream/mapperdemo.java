package com.example.java8stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class mapperdemo
{
    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Abd","Ben","KingKohli");

        System.out.println("Impereative Style:");

        for (String name : names) {
            if (!name .equals("Ben")) {
                User user = new User(name);
                System.out.println(user);
            }
        }
        System.out.println("Functional Style:");
        names.stream()
                .filter(mapperdemo::isNotBen)
                .map(User::new)
                .collect(Collectors.toList());
    }
    private static boolean isNotBen(String name) {
        return !name.equals("Ben");
    }
    static class User {
        private String name;
        private Integer age = 30;

        public User(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name=name;
        }
        public Integer getAge() {
            return age;
        }
        public void  setAge(Integer age){
            this.age=age;
        }
        @Override
        public String toString() {
            return " name : " + name + " age :" + age;
        }
    }

}
