package com.bengkel.booking.services;

import java.util.List;
import java.util.Scanner;

import com.bengkel.booking.models.Customer;
import com.bengkel.booking.models.ItemService;
import com.bengkel.booking.repositories.CustomerRepository;
import com.bengkel.booking.repositories.ItemServiceRepository;

public class MenuService {
    private static List<Customer> listAllCustomers = CustomerRepository.getAllCustomer();
    private static List<ItemService> listAllItemService = ItemServiceRepository.getAllItemService();
    private static BengkelService bengkelService = new BengkelService();
    private static Scanner input = new Scanner(System.in);

    public static void run() {
        boolean isLooping = true;
        do {
            login();
            mainMenu();
        } while (isLooping);

    }

    public static void login() {
        int maxLoginAttempts = 3;
        int loginAttempts = 0;
        boolean isCustomerFound = false;
        boolean isPasswordCorrect = false;

        while (loginAttempts < maxLoginAttempts) {
            System.out.println("Login Bengkel Booking");
            System.out.println("======================");
            System.out.println("Masukan ID Customer:");
            String customerId = input.nextLine();
            System.out.println("Masukan Password:");
            String password = input.nextLine();

            Customer customer = bengkelService.getCustomerById(customerId, listAllCustomers);

            if (customer != null) {
                isCustomerFound = true;

                if (customer.getPassword().equals(password)) {
                    isPasswordCorrect = true;
                    break;
                } else {
                    System.out.println("Password yang Anda masukkan salah! Silakan coba lagi.");
                }
            } else {
                System.out.println("Customer Id tidak ditemukan atau salah! Silakan coba lagi.");
            }
            loginAttempts++;
            if (loginAttempts >= maxLoginAttempts) {
                System.out.println("Anda telah melebihi batas percobaan login. Aplikasi akan keluar.");
                System.exit(0);
            }
        }

        if (isCustomerFound && isPasswordCorrect) {
            System.out.println("Login berhasil. Selamat datang di Home Menu Aplikasi Booking Bengkel!");
        }

    }

    public static void mainMenu() {
        String[] listMenu = {"Informasi Customer", "Booking Bengkel", "Top Up Bengkel Coin", "Informasi Booking", "Logout"};
        int menuChoice = 0;
        boolean isLooping = true;

        do {
            PrintService.printMenu(listMenu, "Booking Bengkel Menu");
            menuChoice = Validation.validasiNumberWithRange("Masukan Pilihan Menu:", "Input Harus Berupa Angka!", "^[0-9]+$", listMenu.length - 1, 0);
            System.out.println(menuChoice);

            switch (menuChoice) {
                case 1:
                    //panggil fitur Informasi Customer
                    break;
                case 2:
                    //panggil fitur Booking Bengkel
                    break;
                case 3:
                    //panggil fitur Top Up Saldo Coin
                    break;
                case 4:
                    //panggil fitur Informasi Booking Order
                    break;
                default:
                    System.out.println("Logout");
                    isLooping = false;
                    break;
            }
        } while (isLooping);


    }

    //Silahkan tambahkan kodingan untuk keperluan Menu Aplikasi
}
