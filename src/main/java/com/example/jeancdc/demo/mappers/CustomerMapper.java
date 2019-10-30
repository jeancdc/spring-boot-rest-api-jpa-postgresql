package com.example.jeancdc.demo.mappers;

import com.example.jeancdc.demo.persistence.entities.CustomerEntity;
import com.example.jeancdc.demo.rest.models.Customer;

import java.util.List;

public interface CustomerMapper {

    Customer customerEntityToCustomerDto(CustomerEntity customerEntity);
    CustomerEntity customerToCustomerEntity(Customer customer);
    List<Customer> customerEntitiesToCustomersDto(List<CustomerEntity> customerEntities);
}
