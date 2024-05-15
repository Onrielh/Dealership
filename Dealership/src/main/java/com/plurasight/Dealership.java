package com.plurasight;

import java.util.ArrayList;

public class Dealership {
    // attributes
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // Constructor

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        // instantiate the ArrayList in the obstructor
        this.inventory = new ArrayList<Vehicle>();
    }
    // getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // other Methods
   public Vehicle getVehiclesByPrice(float min, float max){
       return null;
   }
   public Vehicle getVehicleByMakeModel( String make, String model) {
       return null;
   }
    public Vehicle getVehicleByYear(float min, float max) {
        return null;
    }
   public Vehicle getVehiclebyColor(String color){
       return null;
   }
    public Vehicle getVehicleByMileage(float min, float max) {
        return null;
    }
    public Vehicle getVehicleByType( String vehicleType) {
        return null;
    }
    public ArrayList<Vehicle> getAllVehicle() {
        return inventory;
    }
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);

    }
    public void removeVehicle(Vehicle vehicle) {
    }

}
