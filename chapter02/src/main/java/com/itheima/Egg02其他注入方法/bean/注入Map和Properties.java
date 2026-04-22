package com.itheima.Egg02其他注入方法.bean;


import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class 注入Map和Properties {
    private List<String> names;
    private Set<String> addresses;
//    注入Map类型的属性
    private Map<String, String> phones;
    private Properties properties;

    @Override
    public String toString() {
        return "注入Map和Properties{" +
                "names=" + names +
                ", addresses=" + addresses +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }
}

