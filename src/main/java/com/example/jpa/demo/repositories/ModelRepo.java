package com.example.jpa.demo.repositories;

import com.example.jpa.demo.domain.Model;
import com.example.jpa.demo.domain.ModelType;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModelRepo extends JpaRepository<Model, Long> {

  @Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
  List<Model> queryByPriceRangeAndWoodType(
      @Param("lowest") BigDecimal low,
      @Param("highest") BigDecimal high,
      @Param("wood") String wood
  );
}
