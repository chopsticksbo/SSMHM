package com.itheima.pojo;

public class FileInfo {
    private String name;				//name属性表示文件名称
    public FileInfo() { }
    public FileInfo(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}