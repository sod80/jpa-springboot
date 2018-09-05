package com.example.jpa.demo;

import static org.junit.Assert.assertEquals;

import com.example.jpa.demo.domain.Location;
import com.example.jpa.demo.repositories.LocationRepo;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationRepoTests {

	@Autowired
	private LocationRepo locationRepo;

	private Location myLocation;

	@PersistenceContext
	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
		myLocation = new Location(1L, "ALA", "USA", null);
	}

	@Test
	public void shouldFindAllLocationRecords() {
		locationRepo.save(myLocation);

		List<Location> location = locationRepo.findAll();

		Assert.assertEquals("Expected 1 location record", 1, location.size());
	}

	@Test
	@Transactional
	public void shouldSaveAndGetAndDeleteLocation() {
		locationRepo.saveAndFlush(myLocation);

		entityManager.clear();

		Optional<Location> location = locationRepo.findById(myLocation.getId());

		assertEquals("USA", location.get().getCountry());
		assertEquals("ALA", location.get().getState());

		//delete BC location now
		locationRepo.delete(location.get());
	}

	@Test
	public void shouldFindWithLike() {
		Location myLocation1 = new Location(1L, "BALAS", "USA", null);
		Location myLocation2 = new Location(2L, "CALAC", "USA", null);
		Location myLocation3 = new Location(3L, "CALCC", "USA", null);
		Location myLocation4 = new Location(4L, "SECA", "USA", null);
		locationRepo.saveAndFlush(myLocation1);
		locationRepo.saveAndFlush(myLocation2);
		locationRepo.saveAndFlush(myLocation3);
		locationRepo.saveAndFlush(myLocation4);

		List<Location> locations = locationRepo.findByStateLike("CA%");

		assertEquals(2, locations.size());

		locations = locationRepo.findByStateLike("%CA%");

		assertEquals(3, locations.size());

	}
}
