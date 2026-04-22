package com.itheima.Egg02其他注入方法.bean;

public class Student {
    private String username;
    private Integer age;
    private String password;
    private StudentClass studentClass;

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", studentClass=" + studentClass +
                '}';
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
