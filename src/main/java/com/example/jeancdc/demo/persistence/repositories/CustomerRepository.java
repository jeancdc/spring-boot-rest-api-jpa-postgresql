package com.example.jeancdc.demo.persistence.repositories;

import com.example.jeancdc.demo.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByLastName(String lastName);
    List<CustomerEntity> findByLastNameAndAge(String lastName, int age);
    List<CustomerEntity> findAllByIdGreaterThanOrderByFirstNameDesc(Long id);
    CustomerEntity findById(long id);
}
