package com.example.jeancdc.demo.controller;

import com.example.jeancdc.demo.persistence.entities.CustomerEntity;
import com.example.jeancdc.demo.persistence.repositories.CustomerRepository;
import com.example.jeancdc.demo.rest.controllers.CustomerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
// @SpringBootTest(classes = CustomerController.class)
@WebMvcTest(CustomerController.class)
// @AutoConfigureMockMvc
public class CustomerControllerTest {

    private static final Logger log = LoggerFactory.getLogger(CustomerControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    /* @Autowired
    WebApplicationContext webApplicationContext; */

    @Autowired
    private CustomerController customerController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

        List<CustomerEntity> customerEntities = new ArrayList<>();
        customerEntities.add(new CustomerEntity("John", "Rambo", 36));
        Mockito.when(customerRepository.findAll()).thenReturn(customerEntities);
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(customerController).isNotNull();
    }

    @Test
    public void getCustomers_method() {
        // when
        // List<CustomerEntity> customerEntities = customerController.getCustomers();

        // then
        // assertEquals(customerEntities.size(), 1);
    }

    @Test
    public void getCustomers_endpoint_return200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customers")
                .header("Accept", "application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCustomerById() {
    }
}
