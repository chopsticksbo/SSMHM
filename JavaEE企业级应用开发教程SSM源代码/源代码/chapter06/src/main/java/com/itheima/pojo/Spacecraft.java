package com.itheima.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Spacecraft {
    private int id;		  //编号
    private String name;  //名称


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Spacecraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}