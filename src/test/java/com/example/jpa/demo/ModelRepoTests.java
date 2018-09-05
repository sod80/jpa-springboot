package com.example.jpa.demo;

import com.example.jpa.demo.domain.Model;
import com.example.jpa.demo.domain.ModelType;
import com.example.jpa.demo.repositories.ModelRepo;
import com.example.jpa.demo.repositories.ModelTypeRepo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
public class ModelRepoTests {

	@Autowired
	private ModelRepo modelRepo;

	private Model model;
	private ModelType modelType;

	private List<Model> modelList;


	@PersistenceContext
	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
	  Model model1 = new Model(1L, "Model1", BigDecimal.valueOf(100L), 5, "Oak", new Date(), null, null);
		Model model2 = new Model(2L, "Model2", BigDecimal.valueOf(100L), 5, "Oak", new Date());
		Model model3 = new Model(3L, "Model3", BigDecimal.valueOf(100L), 5, "Oak", new Date());
		Model model4 = new Model(4L, "Model4", BigDecimal.valueOf(100L), 5, "Oak", new Date());

	  modelList = new ArrayList<>(Arrays.asList(model1,model2,model3,model4));

	}

	@Test
  public void shouldSaveModel() {
		Model model1 = new Model(1L, "Model1", BigDecimal.valueOf(100L), 5, "Oak", new Date(), null, null);

		modelRepo.saveAndFlush(model1);
	}

  @Test
	@Transactional
  public void shouldFindModelById() {
		Model model1 = new Model(1L, "Model1", BigDecimal.valueOf(100L), 5, "Oak", new Date(), null, null);

		modelRepo.saveAndFlush(model1);

		entityManager.clear();

		Optional<Model> model = modelRepo.findById(model1.getId());
		Assert.assertTrue(model.isPresent());
  }

	@Test
	public void shouldFindAllModelTypeRecords() {

	}
}
