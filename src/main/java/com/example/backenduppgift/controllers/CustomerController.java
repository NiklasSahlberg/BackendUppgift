package com.example.backenduppgift.controllers;

import com.example.backenduppgift.models.Customer;
import com.example.backenduppgift.dao.CustomerDAO;
import com.example.backenduppgift.models.Response;
import com.example.backenduppgift.models.Shop;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/customers/add")
    public Response addCustomer(@RequestBody Customer customer) {
        System.out.println(customer.getId() + " " + customer.getNamn());
        Response res = new Response("Item added", Boolean.FALSE);
        customerData.add(customer);

        res.setStatus(Boolean.TRUE);
        System.out.println(customerData);
        return res;
    }

}
