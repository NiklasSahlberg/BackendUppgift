package com.example.backenduppgift.controllers;

import com.example.backenduppgift.models.Customer;
import com.example.backenduppgift.models.CustomerDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CustomerController {
    CustomerDAO customerDAO = new CustomerDAO();
    List<Customer> customerData = customerDAO.getAllCustomer();
    Customer customer;


    @RequestMapping("/customers/:id")
    public Customer getItemById(@PathParam("id") int id) {


        customerData.forEach(data -> {
            if (data.getId() == id) {
                customer = new Customer(data.getId(), data.getNamn());
            }
        });


        return customer;
    }

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(){return  customerData;}
}
