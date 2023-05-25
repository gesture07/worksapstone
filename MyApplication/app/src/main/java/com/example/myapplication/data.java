package com.example.myapplication;

public class data {
    private String id;
    private String name;
    private String explan;

    public data(String id, String name, String explan) {
        this.id = id;
        this.name = name;
        this.explan = explan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return explan;
    }
    public  void setExplan(){
        this.explan = explan;
    }
}

