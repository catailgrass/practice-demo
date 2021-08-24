package com.flycat.common_practice.serialize;

import java.io.Serializable;

public class TestObject implements Serializable {
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String toString(){
        return "name:" + this.name + " ; pwd:" + this.pwd + "\n" + this.hashCode() + "\n";
    }
}
