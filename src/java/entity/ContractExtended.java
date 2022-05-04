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
public class ContractExtended {
    private int id;
    private int  moto_id;
    private int  user_id;
    private Date  date;
    private String  contract_type;
    private int  staff_id;
    private String  status;
    private String fullname;
    private String phone;
    private String email;
    private String address;
    private int isenable;

    public ContractExtended() {
    }

    public ContractExtended(int id, int moto_id, int user_id, Date date, String contract_type, int staff_id, String status, String fullname, String phone, String email, String address, int isenable) {
        this.id = id;
        this.moto_id = moto_id;
        this.user_id = user_id;
        this.date = date;
        this.contract_type = contract_type;
        this.staff_id = staff_id;
        this.status = status;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.isenable = isenable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoto_id() {
        return moto_id;
    }

    public void setMoto_id(int moto_id) {
        this.moto_id = moto_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
