package com.example.backenduppgift.models;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {


    public List<Customer> getAllCustomer(){
        List<Customer> customerList = new ArrayList<>();
        Customer item1 = new Customer(1, "Panos");
        Customer item2 = new Customer(2,"Niklas");
        Customer item3 = new Customer(3,"Peter");
        Customer item4 = new Customer(4, "Anna");

        customerList.add(item1);
        customerList.add(item2);
        customerList.add(item3);
        customerList.add(item4);

        return customerList;
    }
}
