package com.bengkel.booking.services;

import java.util.List;

import com.bengkel.booking.models.Car;
import com.bengkel.booking.models.Customer;
import com.bengkel.booking.models.Vehicle;

public class PrintService {

    public static void printMenu(String[] listMenu, String title) {
        String line = "+---------------------------------+";
        int number = 1;
        String formatTable = " %-2s. %-25s %n";

        System.out.printf("%-25s %n", title);
        System.out.println(line);

        for (String data : listMenu) {
            if (number < listMenu.length) {
                System.out.printf(formatTable, number, data);
            } else {
                System.out.printf(formatTable, 0, data);
            }
            number++;
        }
        System.out.println(line);
        System.out.println();
    }

    public static void printVechicle(List<Vehicle> listVehicle) {
        String formatTable = "| %-2s | %-15s | %-10s | %-15s | %-15s | %-5s | %-15s |%n";
        String line = "+----+-----------------+------------+-----------------+-----------------+-------+-----------------+%n";
        System.out.format(line);
        System.out.format(formatTable, "No", "Vechicle Id", "Warna", "Brand", "Transmisi", "Tahun", "Tipe Kendaraan");
        System.out.format(line);
        int number = 1;
        String vehicleType = "";
        for (Vehicle vehicle : listVehicle) {
            if (vehicle instanceof Car) {
                vehicleType = "Mobil";
            } else {
                vehicleType = "Motor";
            }
            System.out.format(formatTable, number, vehicle.getVehiclesId(), vehicle.getColor(), vehicle.getBrand(), vehicle.getTransmisionType(), vehicle.getYearRelease(), vehicleType);
            number++;
        }
        System.out.printf(line);
    }

    //Silahkan Tambahkan function print sesuai dengan kebutuhan.

    public void showInformationNonMember(List<Customer> customers, String customerId) {
        Customer customerInformation = customers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst().orElse(null);

        int num = 1;
        System.out.println("Non Member");
        System.out.println("Customer Profile");
        System.out.println("Customer Id : " + customerInformation.getCustomerId());
        System.out.println("Nama : " + customerInformation.getName());
        System.out.println("Customer Status : Non Member");
        System.out.println("Alamat : " + customerInformation.getAddress());
        System.out.println("List Kendaraan : ");
        System.out.printf("| %-10s | %-10s | %-15s | %-15s | %-15s |\n",
                "No.", "Vehicle ID", "Warna", "Tipe Kendaraan", "Tahun");
        System.out.println("+========================================================================================+");
        for (Vehicle vehicle : customerInformation.getVehicles()) {
            System.out.printf("| %-10s | %-10s | %-15s | %-15s | %-15s |\n",
                    num, vehicle.getVehiclesId(), vehicle.getColor(), vehicle.getVehicleType(), vehicle.getYearRelease());
            num++;
        }
        System.out.println("+========================================================================================+");
    }
}
