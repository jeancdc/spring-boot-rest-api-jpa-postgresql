package com.example.jeancdc.demo.mappers.impl;

import com.example.jeancdc.demo.mappers.CustomerMapper;
import com.example.jeancdc.demo.persistence.entities.CustomerEntity;
import com.example.jeancdc.demo.rest.models.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerEntityToCustomerDto(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }

        Customer customer = new Customer();

        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setAge(customerEntity.getAge());
        customer.setId(customerEntity.getId());

        return customer;
    }

    @Override
    public CustomerEntity customerToCustomerEntity(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setAge(customer.getAge());
        customerEntity.setId(customer.getId());

        return customerEntity;
    }

    @Override
    public List<Customer> customerEntitiesToCustomersDto(List<CustomerEntity> customerEntities) {
        if (customerEntities == null) {
            return null;
        }

        List<Customer> list = new ArrayList<>(customerEntities.size());
        for (CustomerEntity customerEntity : customerEntities) {
            list.add(customerEntityToCustomerDto(customerEntity));
        }

        return list;
    }
}
