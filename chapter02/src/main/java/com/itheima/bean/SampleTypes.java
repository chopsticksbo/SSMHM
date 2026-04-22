package com.itheima.bean;

import java.util.Date;

public class SampleTypes
{
    public enum Season
    {
        SPRING, SUMMER, AUTUMN, WINTER
    }
    private int age;
    private String name;
    private boolean flag;
    private char sex;
    private double salary;
    private  Class clazz;
    private Season season;
    private Date birthDate;

    @Override
    public String toString() {
        return "注入简单类型SampleTypes{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                ", sex=" + sex +
                ", salary=" + salary +
                ", clazz=" + clazz +
                ", season=" + season +
                ", birthDate=" + birthDate +
                '}';
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
