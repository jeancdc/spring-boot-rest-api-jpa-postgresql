package com.example.jeancdc.demo.repository;

import com.example.jeancdc.demo.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    List<Customer> findByLastNameAndAge(String lastName, int age);
    List<Customer> findAllByIdGreaterThanOrderByFirstNameDesc(Long id);
    Customer findById(long id);
}
