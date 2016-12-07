package com.example.svlib;

import com.example.sv.configs.GlobalConfig;

public class Test2 {
    private String name;

    public Test2(String name) {
        GlobalConfig.class.getName();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
