package com.example.jeancdc.demo.repository;

import com.example.jeancdc.demo.pojo.Customer;
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
        Customer customer = new Customer("John", "Rambo", 36);
        customerRepository.save(customer);

        // when
        List<Customer> customers = customerRepository.findByLastName("Rambo");

        // then
        assertEquals(customer, customers.get(0));
        assertThat(customers.isEmpty(), is(false));
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
