package com.example.jeancdc.demo.controller;

import com.example.jeancdc.demo.error.HttpNotFoundException;
import com.example.jeancdc.demo.pojo.Customer;
import com.example.jeancdc.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new HttpNotFoundException("There are no customers returned by the API!");
        }
        return customers;
    }

    @GetMapping(value = "/customer")
    public Optional<Customer> getCustomerById(@RequestParam(value = "id") Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (Optional.empty().equals(customer)) {
            throw new HttpNotFoundException("The customer with id " + id + " was not found!");
        }
        return customer;
    }

}
