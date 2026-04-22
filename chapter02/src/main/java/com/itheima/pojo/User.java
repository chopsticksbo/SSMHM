package com.itheima.pojo;

public class User {
    private int id;
    private String name;

    public User() {
        System.out.println("User类中无参的构造方法执行成功！");
    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("User类中2个参数的构造方法执行成功！");
    }
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
        return "UserDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
