package com.qf.pojo;

public class User {
    private int u_id;
    private String u_name;
    private String u_email;
    private String u_pass;
    private String u_gender;

    public User(String u_name, String u_email, String u_pass, String u_gender) {
        this.u_name = u_name;
        this.u_email = u_email;
        this.u_pass = u_pass;
        this.u_gender = u_gender;
    }

    public User() {
    }

    public User(int u_id, String u_name, String u_email, String u_pass, String u_gender) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_email = u_email;
        this.u_pass = u_pass;
        this.u_gender = u_gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_email='" + u_email + '\'' +
                ", u_pass='" + u_pass + '\'' +
                ", u_gender='" + u_gender + '\'' +
                '}';
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public String getU_gender() {
        return u_gender;
    }

    public void setU_gender(String u_gender) {
        this.u_gender = u_gender;
    }


}
