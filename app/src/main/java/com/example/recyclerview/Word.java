package com.example.recyclerview;

public class Word {
    private String name;
    private String year;

    public Word(String name, String year){
        this.name = name;
        this.year = year;
    }
    public String getName() {
        return name;
    }

    public void setNama(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYears(String year) {
        this.year = year;
    }
}
