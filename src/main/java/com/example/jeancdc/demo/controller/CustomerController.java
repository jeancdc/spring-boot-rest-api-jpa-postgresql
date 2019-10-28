package com.example.jeancdc.demo.controller;

import com.example.jeancdc.demo.error.HttpNotFoundException;
import com.example.jeancdc.demo.pojo.Customer;
import com.example.jeancdc.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        log.info("customers:" + customers);
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
