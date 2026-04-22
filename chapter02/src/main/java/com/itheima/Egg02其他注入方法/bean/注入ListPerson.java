package com.itheima.Egg02其他注入方法.bean;

import java.util.List;
import java.util.Set;

public class 注入ListPerson {
    private List<String> names;
    private Set<String> addresses;

    @Override
    public String toString() {
        return "注入ListPerson{" +
                "names=" + names +
                ", addresses=" + addresses +
                '}';
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }
}
