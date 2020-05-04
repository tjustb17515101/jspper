package com.lin.pojo;


import java.util.function.BinaryOperator;

public class User {

    private Integer id;
    private Integer uno;
    private String upass;
    private String uname;
    private Byte sex;

    public User() {
    }

    public User(Integer uno, String upass,String uname, Byte sex) {
        this.uno = uno;
        this.upass = upass;
        this.uname = uname;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uno=" + uno +
                ", uname=" + uname +
                ", sex=" + sex +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }
}
