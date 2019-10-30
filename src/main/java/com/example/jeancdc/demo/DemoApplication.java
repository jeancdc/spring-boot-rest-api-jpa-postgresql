package com.example.jeancdc.demo;

import com.example.jeancdc.demo.persistence.entities.CustomerEntity;
import com.example.jeancdc.demo.persistence.repositories.CustomerRepository;
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

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few CustomerEntitys
			repository.save(new CustomerEntity("Jack", "Bauer", 30));
			repository.save(new CustomerEntity("Chloe", "O'Brian", 31));
			repository.save(new CustomerEntity("Kim", "Bauer", 29));
			repository.save(new CustomerEntity("David", "Palmer", 34));
			repository.save(new CustomerEntity("Michelle", "Dessler", 33));
			repository.save(new CustomerEntity("Snake", "Plissken", 36));

			log.info("");

			// fetch all CustomerEntitys
			log.info("CustomerEntitys found with findAll():");
			log.info("-------------------------------");
			for (CustomerEntity CustomerEntity : repository.findAll()) {
				log.info(CustomerEntity.toString());
			}
			log.info("");

			// fetch an individual CustomerEntity by ID
			CustomerEntity CustomerEntity = repository.findById(1L);
			log.info("CustomerEntity found with findById(1L):");
			log.info("---------------------------------");
			log.info(CustomerEntity.toString());
			log.info("");

			// fetch CustomerEntitys by last name
			log.info("CustomerEntitys found with findByLastName('Bauer'):");
			log.info("---------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");

			// fetch CustomerEntitys by last name and by age
			log.info("CustomerEntity found with findByLastNameAndAge('Bauer', 29):");
			log.info("------------------------------------------------------");
			repository.findByLastNameAndAge("Bauer", 29).forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");

			// fetch CustomerEntitys by id greater than
			log.info("CustomerEntitys found with findAllByIdGreaterThanOrderByFirstNameDesc(2L):");
			log.info("--------------------------------------------------------------------");
			repository.findAllByIdGreaterThanOrderByFirstNameDesc(2L).forEach(c -> {
				log.info(c.toString());
			});
			log.info("");
		};
	}

}
