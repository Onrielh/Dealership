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
    public List<Vehicle> vehicles;
    public String vehicleType;
    public Vehicle vehicle;
    boolean running = true;
    String line;

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


    private void init() {
        // Initalize the variable.
        dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }



    private void processGetByPriceRequest() {
        double min = 0;
        double max = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                // Ask user for the minimum price.
                System.out.print("Enter minimum price: ");
                min = scanner.nextDouble();
                scanner.nextLine();

                // Ask user for the maximum price.
                System.out.print("Enter maximum price: ");
                max= scanner.nextDouble();
                scanner.nextLine();

                // Set validInput to true to stop the loop.
                validInput = true;
                // Print error if invalid input.
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid price.");
                // Clear the invalid input.
                scanner.nextLine();
            }
        }
    }

    private void processRemoveVehicleRequest() {
        System.out.println("Please enter the VIN number of the vehicle you wish to remove");
        int input = scanner.nextInt();
        if( input== vehicle.getVin()){
            vehicles.remove(vehicles);
        }

        }



    private void processAddVehicleRequest() {
        System.out.println("Please Enter the Details of the Vehicle you wish to add");
        System.out.println("VIN:");
        int vin = scanner.nextInt();
        System.out.println("Year: ");
        int year = scanner.nextInt();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Vehicle type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        // Create a new vehicle object.
        vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        // Save the dealership after adding the vehicle
        dealershipFileManager.saveDealership(dealership);

        // Print success message.
        System.out.println("\nVehicle added successfully!");
        // Print error if invalid input.
    }




    private void processGetAllVehiclesRequest() {
        for(Vehicle vehicle:vehicles){
            System.out.println(vehicle);
        }
    }
    private void processGetByVehicleTypeRequest() {
        System.out.println("Please Enter the Vehicle Type ~ \n");
        String type = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader("Inventory.csv"))){
            br.readLine();
            while ((line = br.readLine()) != null) {
                // first have to split the array
                String[] data = line.split("\\|");
                //split the specific data piece you want to pull,
                if (type.equalsIgnoreCase(vehicle.getVehicleType())) {
                    System.out.println(vehicle);
                    }
            }} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processGetByMileageRequest() {
        int minMileage = 0;
        int maxMileage = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                // Ask the user for the minimum mileage.
                System.out.print("Enter minimum mileage: ");
                minMileage = scanner.nextInt();

                // Ask the user for the maximum mileage.
                System.out.print("Enter maximum mileage: ");
                maxMileage = scanner.nextInt();

                // Set validInput to true to stop the loop.
                validInput = true;
                // Print error if invalid input.
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid mileage.");
                // Clear the invalid input.
                scanner.nextLine();
            }

    }}

    private void processGetByColorRequest() {
        System.out.println("Please Enter the Vehicle Color~ \n");
        String color = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader("Inventory.csv"))){
            br.readLine();
            while ((line = br.readLine()) != null) {
                // first have to split the array
                String[] data = line.split("\\|");
                //split the specific data piece you want to pull,
                if (color.equalsIgnoreCase(vehicle.getColor())) {
                    System.out.println(vehicles);
                }
            }} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processGetByYearRequest() {
            int minYear = 0;
            int maxYear = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    // Ask the user for the minimum year.
                    System.out.print("Enter minimum year: ");
                    minYear = scanner.nextInt();

                    // Ask the user for the maximum year.
                    System.out.print("Enter maximum year: ");
                    maxYear = scanner.nextInt();

                    // Set validInput to true to stop the loop.
                    validInput = true;
                    // Print error if invalid input.
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid year.");
                    // Clear the invalid input.
                    scanner.nextLine();
                }
    }}

    private void processGetByMakeModelRequest() {
        System.out.println("Please Enter the Make and Model, separated by a comma ~ \n");
        System.out.println("Make: ");
        String make = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        ArrayList<Vehicle> makeandModel = dealership.getVehicleByMakeModel(make, model);
        if (makeandModel.isEmpty()) {
            System.out.println("No vehicles were found");
        } else {
            System.out.println("Vehicles matching make '" + make + "' and model '" + model + "':");
        }
    }
}