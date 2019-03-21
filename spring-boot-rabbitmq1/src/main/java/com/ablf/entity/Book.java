package com.ablf.entity;

/**
 * Created by du on 2019/2/25.
 */
public class Book {

    private String name;
    private String provice;

    public Book(String name, String provice) {
        this.name = name;
        this.provice = provice;
    }

    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", provice='" + provice + '\'' +
                '}';
    }
}
