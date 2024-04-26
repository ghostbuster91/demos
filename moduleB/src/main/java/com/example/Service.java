package com.example;

import java.util.List;

public class Service {

    public static String hello(){
        return "hello";
    }

    public String nonStaticHello(){
        return "nonStatic";
    }


    public static void main(String[] args) {
        System.out.println(Service.nonStaticHello()());
    }
}
