/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Duongdt
 */
public class MotorBike {
    private int id;
    private int user_id;
    private String color;
    private String brand;
    private String lisence_plate;
    private String vehicle_capacity;

    public MotorBike() {
    }

    public MotorBike(int id, int user_id, String color, String brand, String lisence_plate, String vehical_capacity) {
        this.id = id;
        this.user_id = user_id;
        this.color = color;
        this.brand = brand;
        this.lisence_plate = lisence_plate;
        this.vehicle_capacity = vehical_capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLisence_plate() {
        return lisence_plate;
    }

    public void setLisence_plate(String lisence_plate) {
        this.lisence_plate = lisence_plate;
    }

    public String getVehical_capacity() {
        return vehicle_capacity;
    }

    public void setVehical_capacity(String vehical_capacity) {
        this.vehicle_capacity = vehical_capacity;
    }
    
}
