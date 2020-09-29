package com.lhwl.wzk;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public enum test {

    VIDEO(1,2, "视频");

    int value;
    int two;
    String name;

    test(int value, int two, String name) {
        this.value = value;
        this.two = two;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Apple apple=new Apple();
        apple.setColor("green");
        apple.setWeight(20);
        List<Apple> list=new ArrayList<>();
        list.add(apple);
        //System.out.println(filterApples(list, Apple::isGreenApple));

       // System.out.println(test.AUDIO.getName());
        System.out.println(test.VIDEO.getTwo());
        System.out.println(test.getByValue(1));

    }

    static List filterApples(List<Apple> inventory, Predicate p) {
        List result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    public static test getByValue(int value) {
        for(test typeEnum : test.values()) {
            if(typeEnum.value == value) {
                return typeEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }


}
