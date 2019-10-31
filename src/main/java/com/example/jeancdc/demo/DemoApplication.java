package com.example.jeancdc.demo;

import com.example.jeancdc.demo.persistence.entities.CustomerEntity;
import com.example.jeancdc.demo.persistence.entities.VehicleEntity;
import com.example.jeancdc.demo.persistence.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository) {
		return (args) -> {
			// save a few CustomerEntities
			customerRepository.save(new CustomerEntity("Jack", "Bauer", 30, new VehicleEntity("Citroen Xsara")));
			customerRepository.save(new CustomerEntity("Chloe", "O'Brian", 31, new VehicleEntity("Citronault Pipo")));
			customerRepository.save(new CustomerEntity("Kim", "Bauer", 29, new VehicleEntity("Renault Clio")));
			customerRepository.save(new CustomerEntity("David", "Palmer", 34));
			customerRepository.save(new CustomerEntity("Michelle", "Dessler", 33, new VehicleEntity("Nissan Micra")));
			customerRepository.save(new CustomerEntity("Snake", "Plissken", 36));

			/* log.info("");

			// fetch all CustomerEntities
			log.info("CustomerEntities found with findAll():");
			log.info("-------------------------------");
			for (CustomerEntity CustomerEntity : customerRepository.findAll()) {
				log.info(CustomerEntity.toString());
			}
			log.info("");

			// fetch an individual CustomerEntity by ID
			CustomerEntity CustomerEntity = customerRepository.findById(1L);
			log.info("CustomerEntity found with findById(1L):");
			log.info("---------------------------------");
			log.info(CustomerEntity.toString());
			log.info("");

			// fetch CustomerEntities by last name
			log.info("CustomerEntities found with findByLastName('Bauer'):");
			log.info("---------------------------------------------");
			customerRepository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");

			// fetch CustomerEntities by last name and by age
			log.info("CustomerEntity found with findByLastNameAndAge('Bauer', 29):");
			log.info("------------------------------------------------------");
			customerRepository.findByLastNameAndAge("Bauer", 29).forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");

			// fetch CustomerEntities by id greater than
			log.info("CustomerEntities found with findAllByIdGreaterThanOrderByFirstNameDesc(2L):");
			log.info("--------------------------------------------------------------------");
			customerRepository.findAllByIdGreaterThanOrderByFirstNameDesc(2L).forEach(c -> {
				log.info(c.toString());
			});
			log.info(""); */
		};
	}

}
