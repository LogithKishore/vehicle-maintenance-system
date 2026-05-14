import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    private String ownerName;
    private String vehicleNumber;
    private String vehicleModel;
    private String maintenanceDate;
    private boolean maintenanceCompleted;

    Vehicle(String ownerName, String vehicleNumber,
            String vehicleModel, String maintenanceDate) {

        this.ownerName = ownerName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceCompleted = false;
    }

    public void displayDetails() {
        System.out.println("\nOwner Name      : " + ownerName);
        System.out.println("Vehicle Number  : " + vehicleNumber);
        System.out.println("Vehicle Model   : " + vehicleModel);
        System.out.println("Maintenance Date: " + maintenanceDate);
        System.out.println("Status          : "
                + (maintenanceCompleted ? "Completed" : "Pending"));
    }

    public void confirmMaintenance() {
        maintenanceCompleted = true;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}

public class VehicleMaintenanceSystem {

    static ArrayList<Vehicle> vehicleList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== VEHICLE MAINTENANCE SYSTEM =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicle Records");
            System.out.println("3. Confirm Maintenance");
            System.out.println("4. Search Vehicle");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addVehicle();
                    break;

                case 2:
                    viewRecords();
                    break;

                case 3:
                    confirmMaintenance();
                    break;

                case 4:
                    searchVehicle();
                    break;

                case 5:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }

    public static void addVehicle() {

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Vehicle Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Maintenance Date (dd/mm/yyyy): ");
        String date = sc.nextLine();

        Vehicle v = new Vehicle(owner, number, model, date);

        vehicleList.add(v);

        System.out.println("Vehicle Added Successfully!");
    }

    public static void viewRecords() {

        if (vehicleList.isEmpty()) {
            System.out.println("No Records Found!");
        } else {

            for (Vehicle v : vehicleList) {
                v.displayDetails();
                System.out.println("--------------------------------");
            }
        }
    }

    public static void confirmMaintenance() {

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        boolean found = false;

        for (Vehicle v : vehicleList) {

            if (v.getVehicleNumber().equals(number)) {

                v.confirmMaintenance();

                System.out.println("Maintenance Confirmed!");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Vehicle Not Found!");
        }
    }

    public static void searchVehicle() {

        System.out.print("Enter Vehicle Number to Search: ");
        String number = sc.nextLine();

        boolean found = false;

        for (Vehicle v : vehicleList) {

            if (v.getVehicleNumber().equals(number)) {

                v.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Vehicle Record Not Found!");
        }
    }
}
