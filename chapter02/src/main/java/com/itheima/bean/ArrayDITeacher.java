package com.itheima.bean;

public class ArrayDITeacher {
    private  String[] aiHaos;
    private Friends[] friends;

    public void setFriends(Friends[] friends) {
        this.friends = friends;
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

    @Override
    public String toString() {
        return "注入数组ArrayDITeacher{" +
                "aiHaos=" + java.util.Arrays.toString(aiHaos) +
                ", friends=" + java.util.Arrays.toString(friends) +
                '}';
    }
}
