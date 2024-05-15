package com.plurasight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {
    //  create a starter data file
    public Dealership getDealership() {
        //creating buffered reader to read the dealership inventory
        String line;
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.csv"))) {
            // read the first line
            //separate the information in the first line
            String[] dealershipInfo = br.readLine().split("\\|");
            // create dealership object
            dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);
            br.readLine();
            // skip first line
            while ((line = br.readLine()) != null) {
                String[] vehicleData = line.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(vehicleData[0]), Integer.parseInt(vehicleData[1]),
                        vehicleData[2], vehicleData[3], vehicleData[4], vehicleData[5], Integer.parseInt(vehicleData[6]),
                        Double.parseDouble(vehicleData[7]));
                dealership.addVehicle(vehicle);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }}

