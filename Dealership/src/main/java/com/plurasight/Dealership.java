package com.plurasight;

import java.util.ArrayList;

public class Dealership {
    // attributes
    private String name;
    private String address;
    private String phone;
    private final ArrayList<Vehicle> inventory;

    // Constructor

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        // instantiate the ArrayList in the obstructor
        this.inventory = new ArrayList<>();
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
    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        ArrayList<Vehicle> range = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                range.add(vehicle);
            }
        }
        return range;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {
        ArrayList<Vehicle> makeAndModel = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (make.equalsIgnoreCase(vehicle.getMake()) && (model.equalsIgnoreCase(vehicle.getModel()))) {
                makeAndModel.add(vehicle);
            }
        } return makeAndModel;
    }
        public ArrayList<Vehicle> getVehicleByYear (int minYear,int maxYear) {
            ArrayList<Vehicle> yearRange = new ArrayList<>();
            for (Vehicle vehicle : inventory) {
                // sets the range to if the price is greater than the min and less than the max
                if (vehicle.getPrice() >= minYear && vehicle.getPrice() <= maxYear) {
                    yearRange.add(vehicle);
                }

            }
            return yearRange;
        }
            public ArrayList<Vehicle> getVehiclebyColor (String color) {
                ArrayList<Vehicle> colorSearch = new ArrayList<>();
                for (Vehicle vehicle: inventory){
                if (color.equalsIgnoreCase(vehicle.getColor())) {
                    colorSearch.add(vehicle);
                }

            }return colorSearch;
    }
        public ArrayList<Vehicle> getVehicleByMileage (int minMileage, int maxMileage){
            ArrayList<Vehicle> mileageSearch = new ArrayList<>();
            for (Vehicle vehicle : inventory) {
                // sets the range to if the price is greater than the min and less than the max
                if (vehicle.getPrice() >= minMileage && vehicle.getPrice() <= maxMileage) {
                    mileageSearch.add(vehicle);
                }

            }
            return mileageSearch;
        }
        public ArrayList<Vehicle> getVehicleByType (String vehicleType){
            ArrayList<Vehicle> typeSearch = new ArrayList<>();
            for (Vehicle vehicle: inventory) {
                if (vehicleType.equalsIgnoreCase(vehicle.getColor())) {
                    typeSearch.add(vehicle);
                }
            }return typeSearch;
    }
        public ArrayList<Vehicle> getAllVehicle () {
            return inventory;
        }
        public void addVehicle (Vehicle vehicle){
            inventory.add(vehicle);

        }
        public void removeVehicle (Vehicle vehicle){
        }
    }

