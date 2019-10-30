package com.example.jeancdc.demo.repository;

import com.example.jeancdc.demo.persistence.entities.CustomerEntity;
import com.example.jeancdc.demo.persistence.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findByLastName() {

        // given
        CustomerEntity customerEntity = new CustomerEntity("John", "Rambo", 36);
        customerRepository.save(customerEntity);

        // when
        List<CustomerEntity> customerEntities = customerRepository.findByLastName("Rambo");

        // then
        assertEquals(customerEntity, customerEntities.get(0));
        assertThat(customerEntities.isEmpty(), is(false));
    }

    @Test
    public void findByLastNameAndAge() {
    }

    @Test
    public void findAllByIdGreaterThanOrderByFirstNameDesc() {
    }

    @Test
    public void findById() {
    }
}
