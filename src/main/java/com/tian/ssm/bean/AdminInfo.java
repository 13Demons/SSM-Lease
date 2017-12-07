package com.tian.ssm.bean;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class AdminInfo {

    private Integer adminId;

    private String adminCode;



    private String password;

    private String name;



    private String telephone;

    private String email;

    private Date enrolldate;

    public AdminInfo() {
    }

    public AdminInfo(String name) {
        this.name = name;
    }

    public AdminInfo(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public AdminInfo(Integer adminId, String adminCode, String password, String name, String telephone, String email, Date enrolldate) {
        this.adminId = adminId;
        this.adminCode = adminCode;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminId=" + adminId +
                ", adminCode='" + adminCode + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrolldate +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }
}