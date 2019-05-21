package com.amyliascarlet.lib.bean;



public class User {
    private String name;
    private int age;
    private double money;
    private int score;
    public User(){

    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setMoney(double money){
        this.money = money;
    }
    public double getMoney(){
        return this.money;
    }

    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return this.score;
    }
}
