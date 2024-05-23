package com.plurasight;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Dealership dealership;
    public DealershipFileManager dealershipFileManager;
    boolean running = true;


    public void display() {
        init();
        while (running) {
            System.out.println("\t ~ Menu ~");
            System.out.println("(1) Search by price,(2)Search by make and model");
            System.out.println("(3) Search by year,(4)Search by color");
            System.out.println("(5) Search by mileage,(6) Search by vehicle type");
            System.out.println("(7) List all vehicles,(8) Add a vehicle");
            System.out.println("(9) Remove a vehicle,(0) Exit");
            System.out.println("Please Make a Selection");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 0:
                        System.exit(0);
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid Input.");
                }
            } catch (InputMismatchException e) {
                {
                    System.out.println("Please enter a valid number");
                    scanner.nextLine();

                }
            }
        }
    }
    // helper display method
    // will be called by each method to help with formatting
    //similar to toString method
    private void displayVehicles (ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle: vehicles){
            System.out.println(
            "Vin=" + vehicle.getVin() +
                    ", Year=" + vehicle.getYear() +
                    ", Model=" + vehicle.getModel() +
                    ", Make=" + vehicle.getMake() +
                    ", vehicleType=" + vehicle.getVehicleType() +
                    ", Color=" + vehicle.getColor() +
                    ", Odometer=" + vehicle.getOdometer()+
                    ", Price=" + vehicle.getPrice());
        }
        }


    private void processGetByMakeModelRequest() {
        System.out.print("Please Enter the Make:");
        String make = scanner.nextLine();
        System.out.print("Please Enter Model:");
        String model = scanner.nextLine();
        ArrayList<Vehicle> makeAndModel = dealership.getVehicleByMakeModel(make, model);
        if (makeAndModel.isEmpty()) {
            System.out.println(" No Vehicles Found");
        } else {
            System.out.println(makeAndModel);
        }
    }

    private void init() {
        // Initalize the variable.
        dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }
    private void processAddVehicleRequest() {
        System.out.println("Please Enter the Details of the Vehicle you wish to add");
        System.out.print("VIN:");
        int vin = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Vehicle type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        // Create a new vehicle object.
       Vehicle addedVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(addedVehicle);

        // Save the dealership after adding the vehicle
        dealershipFileManager.saveDealership(dealership);

        // Print success message.
        System.out.println(addedVehicle +"\n was added successfully!");
        // Print error if invalid input.
    }

    private void processGetAllVehiclesRequest() {
        for (Vehicle vehicle : dealership.getAllVehicle()) {
            System.out.println(vehicle);
        }
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("Please Enter the Vehicle Type ~ \n");
        String type = scanner.nextLine();
        // create new array list to add search results
        ArrayList<Vehicle> typeSearch = dealership.getVehicleByType(type);
        if (typeSearch.isEmpty()) {
            System.out.println(" No Vehicles Found");
        } else {
            System.out.println("Search results \n");
            displayVehicles(typeSearch);
        }
    }
    private void processGetByPriceRequest() {
        System.out.print("Please Enter Minimum Price:");
        int minPrice = scanner.nextInt();
        System.out.println("Please Enter Maximum Price");
        int maxPrice = scanner.nextInt();
        ArrayList <Vehicle> priceSearch = dealership.getVehiclesByPrice(minPrice,maxPrice);
        if (priceSearch.isEmpty()) {
            System.out.println(" No Vehicles Found");
        } else {
            System.out.println("Search results \n");
            displayVehicles(priceSearch);
        }
    }

    private void processRemoveVehicleRequest() {

        System.out.print("Enter VIN of the vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        // Find the vehicle in the array.
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicle()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }
        // If no vehicle with a matching VIN found, print message.
        if (vehicleToRemove == null) {
            System.out.println("Vehicle not found ");
        } else {
            dealership.removeVehicle(vehicleToRemove);
            dealershipFileManager.saveDealership(dealership);
            System.out.println("\n ~Vehicle removed successfully!~");
        }
    }

            private void processGetByMileageRequest () {
                System.out.print("Please Enter Minimum Mileage:");
                int minMileage = scanner.nextInt();
                System.out.print("Please Enter Maximum Mileage:");
                int maxMileage = scanner.nextInt();
                // create new array list to add search results
                ArrayList<Vehicle> mileageSearch = dealership.getVehicleByMileage(minMileage, maxMileage);
                if (mileageSearch.isEmpty()) {
                    System.out.println(" No Vehicles Found");
                } else {
                    System.out.println("Search Results \n");
                    displayVehicles(mileageSearch);
                }
            }

            private void processGetByColorRequest () {
                System.out.print("Please Enter the Vehicle Color:");
                String color = scanner.nextLine();
                // create new array list to add search results
                // call search by color method
                ArrayList<Vehicle> colorSearch = dealership.getVehiclebyColor(color);
                if (colorSearch.isEmpty()) {
                    System.out.println(" No Vehicles Found");
                } else {
                    System.out.println("Search results \n");
                    displayVehicles(colorSearch);
                }
            }
            private void processGetByYearRequest () {
                System.out.print("Please Enter Minimum Year:");
                int minYear = scanner.nextInt();
                System.out.println("Please Enter Maximum Year");
                int maxYear = scanner.nextInt();
                // set array equal to method
                ArrayList<Vehicle> yearRange = dealership.getVehicleByYear(minYear, maxYear);
                if (yearRange.isEmpty()) {
                    System.out.println(" No Vehicles Found");
                } else {
                    System.out.println("Search results \n");
                    displayVehicles(yearRange);
                }
            }
        }

