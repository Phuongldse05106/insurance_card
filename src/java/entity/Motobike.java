/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Motobike {
    private int id;
    private int userId;
    private String brand;
    private String color;
    private String lisence_plate;
    private String vehicle_capacity;

    public Motobike() {
    }

    public Motobike(int id, int userId, String brand, String color, String lisence_plate, String vehicle_capacity) {
        this.id = id;
        this.userId = userId;
        this.brand = brand;
        this.color = color;
        this.lisence_plate = lisence_plate;
        this.vehicle_capacity = vehicle_capacity;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLisence_plate() {
        return lisence_plate;
    }

    public void setLisence_plate(String lisence_plate) {
        this.lisence_plate = lisence_plate;
    }

    public String getVehicle_capacity() {
        return vehicle_capacity;
    }

    public void setVehicle_capacity(String vehicle_capacity) {
        this.vehicle_capacity = vehicle_capacity;
    }
    
    
}
