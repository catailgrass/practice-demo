package com.flycat.model;

/**
 * Created by flycat on 2018/7/20.
 */
public class Admin {
    private Integer userId;
    private String uName;
    private String uPwd;
    private String rights;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    @Override
    public String toString() {
        System.out.println("this is Admin");
        return "com.flycat.model.Admin";
    }
}
