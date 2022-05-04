/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Duongdt
 */
public class User {
    private int user_id;
    private int role_id;
    private String username;
    private String email;
    private String password;
    private String fullname;
    private Date dob;
    private int gender;
    private String phone;
    private String address;
    private int isenable;

    public User() {
    }

    public User(int user_id, int role_id, String username, String email, String password, String fullname, Date dob, int gender, String phone, String address, int isenable) {
        this.user_id = user_id;
        this.role_id = role_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.isenable = isenable;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return password;
    }

    public void setPasword(String pasword) {
        this.password = pasword;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsenable() {
        return isenable;
    }

    public void setIsenable(int isenable) {
        this.isenable = isenable;
    }
    
    
}
