package com.itheima.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
    private List<String> names;
    private Set<String> addresses;
    private Map<Integer, String> map;

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
