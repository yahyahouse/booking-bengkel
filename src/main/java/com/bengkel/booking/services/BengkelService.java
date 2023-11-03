package com.bengkel.booking.services;

import com.bengkel.booking.models.Customer;
import com.bengkel.booking.models.MemberCustomer;

import java.util.List;

public class BengkelService {

	//Silahkan tambahkan fitur-fitur utama aplikasi disini

	//Login
    public void login(String customerId, String password,List<Customer> customers) {
        Customer customer = getCustomerById(customerId, customers);
        if (customer != null && customer.getPassword().equals(password)) {
            System.out.println("Login berhasil");
        } else {
            System.out.println("Login gagal");
        }
    }

	//Info Customer
    public Customer getCustomerById(String customerId, List<Customer> customers) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);
    }

	//Booking atau Reservation

	//Top Up Saldo Coin Untuk Member Customer

	//Logout

}
