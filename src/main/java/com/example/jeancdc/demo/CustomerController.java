package com.example.jeancdc.demo;

import com.example.jeancdc.demo.pojo.Customer;
import com.example.jeancdc.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return (List<Customer>) customerRepository.findAll();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Optional<Customer> getCustomer(@RequestParam(value="id") Long id) {
        return customerRepository.findById(id);
    }

}
