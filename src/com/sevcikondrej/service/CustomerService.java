package com.sevcikondrej.service;

import com.sevcikondrej.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    void addCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);

    List<Customer> searchCustomers(String theSearchName);
}
