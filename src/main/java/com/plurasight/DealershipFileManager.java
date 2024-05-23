package com.plurasight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    //  create a starter data file
    public Dealership getDealership() {
       // ArrayList<Vehicle> inventory = new ArrayList<>();
        //creating buffered reader to read the dealership inventory
        String line;
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader("Inventory.csv"))) {
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
                //inventory.add(vehicle);
                dealership.addVehicle(vehicle);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }
    // create backup dealership method
    // overwrite with the current dealership information and inventory list
public void saveDealership(Dealership dealership){
        // write information to backup file
    try{
        BufferedWriter bw =new BufferedWriter(new FileWriter("backupInventory.csv"));

     // first line is dealership details
        bw.write(dealership.getName()+ "|" + dealership.getName() +"|" + dealership.getPhone() + "\n");
         for (Vehicle vehicle : dealership.getAllVehicle()) {
             bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                     + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");

         } bw.close();
} catch (IOException e) {
        throw new RuntimeException(e);
}
    }
    }




