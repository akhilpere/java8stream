package com.example.java8stream;

import org.apache.catalina.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class flatmapperex
 {
     public static void main(String[] args)
     {
         List<User> users = Arrays.asList(
                 new User("Abd", 17, Arrays.asList("1", "2")),
                 new User("Ben", 30, Arrays.asList("3", "4", "5")),
                 new User("KingKohli",18,Arrays.asList("8")) );

         System.out.println("Functional Style: ");

         Optional<String> stringOptional = users.stream()
                 .map(user -> user.getPhoneNumbers().stream())
                 .flatMap(stringStream -> stringStream.filter(PhoneNo -> PhoneNo.equals("10")))
                 .findAny();
         stringOptional.ifPresent(System.out::println);

     }
     private static boolean isNotAbd(String name) {
         return !name.equals("Abd");
     }

     static class User {
         private String name;
         private Integer age = 38;
         private List<String> PhoneNumbers;

         public User(String name,Integer age,List<String> Phonenumbers)
         {
             this.name= name;
             this.age= age;
             this.PhoneNumbers= Phonenumbers;
         }

         public List<String> getPhoneNumbers() {
             return PhoneNumbers;
         }
         public void setPhoneNumbers(List<String> PhoneNumbers) {
             this.PhoneNumbers = PhoneNumbers;
         }
         public String getName() {
             return name;
         }
         public void setName(String name) {
             this.name = name;
         }
         public Integer getAge() {
             return age;
         }
         public void setAge(Integer age) {
             this.age=age;
         }
         @Override
         public String toString() {
             return "name :" + name + "age : " + age;
         }
     }
}
