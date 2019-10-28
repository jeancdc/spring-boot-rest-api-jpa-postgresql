package com.example.jeancdc.demo;

import com.example.jeancdc.demo.pojo.Customer;
import com.example.jeancdc.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/* @Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer", 30));
			repository.save(new Customer("Chloe", "O'Brian", 31));
			repository.save(new Customer("Kim", "Bauer", 29));
			repository.save(new Customer("David", "Palmer", 34));
			repository.save(new Customer("Michelle", "Dessler", 33));
			repository.save(new Customer("Snake", "Plissken", 36));

			log.info("");

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("---------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customers found with findByLastName('Bauer'):");
			log.info("---------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");

			// fetch customers by last name and by age
			log.info("Customer found with findByLastNameAndAge('Bauer', 29):");
			log.info("------------------------------------------------------");
			repository.findByLastNameAndAge("Bauer", 29).forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");

			// fetch customers by id greater than
			log.info("Customers found with findAllByIdGreaterThanOrderByFirstNameDesc(2L):");
			log.info("--------------------------------------------------------------------");
			repository.findAllByIdGreaterThanOrderByFirstNameDesc(2L).forEach(c -> {
				log.info(c.toString());
			});
			log.info("");
		};
	} */

}
