package com.example.jpa.demo;

import com.example.jpa.demo.domain.Location;
import com.example.jpa.demo.repositories.LocationRepo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	LocationRepo locationRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Location user1 = new Location(1L, "United States", "Alabama", null);
//		Location user2 = new Location(2L, "United States", "XXX", null);
//		Location user3 = new Location(3L, "United States", "CCC", null);
//		log.info("Inserting data in DB.");
//		locationRepo.save(user1);
//		locationRepo.save(user2);
//		locationRepo.save(user3);
//		log.info("User count in DB: {}", locationRepo.count());
//		log.info("User with ID 1: {}", locationRepo.findById(1L));
//		log.info("Deleting user with ID 2L form DB.");
//		locationRepo.deleteById(2L);
		log.info("**** Location count in DB: {} ****", locationRepo.count());
	}


}
