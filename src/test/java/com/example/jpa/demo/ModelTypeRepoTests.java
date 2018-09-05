package com.example.jpa.demo;

import com.example.jpa.demo.domain.Model;
import com.example.jpa.demo.domain.ModelType;
import com.example.jpa.demo.repositories.ModelTypeRepo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelTypeRepoTests {

	@Autowired
	ModelTypeRepo modelTypeRepo;

	ModelType modelType;

	List<Model> modelList;


	@Before
	public void setUp() throws Exception {
	  Model model1 = new Model(1L, "Model1", BigDecimal.valueOf(100L), 5, "Oak", new Date(), null, null);

	  modelList = new ArrayList<>(Arrays.asList(model1));

    modelType = new ModelType(1L, "SODType", modelList);
	}


  @Test
  public void shouldFindModelTypeByID() {
    ModelType modelType1 = new ModelType();
    modelType1.setName("My model");

	  modelTypeRepo.save(modelType1);

    Optional<ModelType> modelTypesRT = modelTypeRepo.findById(modelType1.getId());

    ModelType returned = modelTypesRT.get();

    Assert.assertEquals("Expected 'My Model' name", "My model", returned.getName());

  }

	@Test
	public void shouldFindAllModelTypeRecords() {
    modelTypeRepo.save(modelType);

		List<ModelType> modelTypes = modelTypeRepo.findAll();

		Assert.assertEquals("Expected 1 modelType record", 1, modelTypes.size());
	}
}
