/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Contract{
    private int contractId;
    private String name;
    private int motoId;
    private int userId;
    private Date date;
    private boolean status;
    
    
    public Contract() {
    }

    public Contract(int contractId, String name, int motoId, int userId, Date date, boolean status) {
        this.contractId = contractId;
        this.name = name;
        this.motoId = motoId;
        this.userId = userId;
        this.date = date;
        this.status = status;
    }

    
    
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMotoId() {
        return motoId;
    }

    public void setMotoId(int motoId) {
        this.motoId = motoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
