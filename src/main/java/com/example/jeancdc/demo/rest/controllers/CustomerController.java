package com.example.jeancdc.demo.rest.controllers;

import com.example.jeancdc.demo.mappers.impl.CustomerMapperImpl;
import com.example.jeancdc.demo.persistence.entities.CustomerEntity;
import com.example.jeancdc.demo.persistence.repositories.CustomerRepository;
import com.example.jeancdc.demo.rest.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private CustomerRepository customerRepository;
    private CustomerMapperImpl customerMapper;

    public CustomerController(CustomerRepository customerRepository, CustomerMapperImpl customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        log.info("customer entities: " + customerEntities);
        List<Customer> customers = customerMapper.customerEntitiesToCustomersDto(customerEntities);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/customer")
    public ResponseEntity<Customer> getCustomerById(@RequestParam(value = "id") Long id) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
        CustomerEntity customerEntity = null;
        if (optionalCustomerEntity.isPresent()) {
            customerEntity = optionalCustomerEntity.get();
        }
        Customer customer = customerMapper.customerEntityToCustomerDto(customerEntity);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
