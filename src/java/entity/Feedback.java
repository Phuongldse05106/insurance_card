/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author chubo
 */
public class Feedback {
    private int id;
    private String fullName;
    private String message;
    private String email;
    private String phone;
    private int isenable;

    public Feedback() {
    }

    public Feedback(int id, String fullName, String message, String email, String phone, int isenable) {
        this.id = id;
        this.fullName = fullName;
        this.message = message;
        this.email = email;
        this.phone = phone;
        this.isenable = isenable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsenable() {
        return isenable;
    }

    public void setIsenable(int isenable) {
        this.isenable = isenable;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", fullName=" + fullName + ", message=" + message + ", email=" + email + ", phone=" + phone + ", isenable=" + isenable + '}';
    }
    
    

}
