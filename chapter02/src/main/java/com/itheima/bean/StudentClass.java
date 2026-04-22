package com.itheima.bean;

public class StudentClass {
    private String className;
    private String classNum;

    public void setClassName(String className) {
        this.className = className;
    }
    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "className='" + className + '\'' +
                ", classNum='" + classNum + '\'' +
                '}';
    }
}
