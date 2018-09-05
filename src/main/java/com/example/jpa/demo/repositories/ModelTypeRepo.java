package com.example.jpa.demo.repositories;

import com.example.jpa.demo.domain.ModelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelTypeRepo extends JpaRepository<ModelType, Long> {

}
