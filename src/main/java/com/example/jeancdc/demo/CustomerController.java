package com.example.jeancdc.demo;

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
        return (List<Customer>) customerRepository.findAll();
    }

    @GetMapping(value = "/customer")
    public Optional<Customer> getCustomerById(@RequestParam(value="id") Long id) {
        return customerRepository.findById(id);
    }

}
