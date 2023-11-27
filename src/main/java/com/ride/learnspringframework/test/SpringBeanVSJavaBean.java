package com.ride.learnspringframework.test;

import java.io.Serializable;

class Pojo {
    private String text;
    private int number;
    public String toString() {
        return text + ":" + number;
    }
}

class JavaBean implements Serializable { //EJB Enterprise Java Bean

    //조건

    //1 Serializable

    //2 no-arg constructor
    public JavaBean() {
    }

    //3 getters, setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private String text;
    private int number;
    public String toString() {
        return text + ":" + number;
    }
}

public class SpringBeanVSJavaBean {
    public static void main(String[] args) {
        Pojo pojo = new Pojo();

        System.out.println(pojo);
    }
}
