package com.lhwl.wzk;

public class Apple {
     String color;
    Integer weight;

    public  String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
/*    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }*/
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }


    public static boolean isGreenApple(Object o) {
        Apple apple= (Apple) o;
        return "green".equals(apple.getColor());
    }


    public static void print(Apple content){
        System.out.println(content);
    }

}
