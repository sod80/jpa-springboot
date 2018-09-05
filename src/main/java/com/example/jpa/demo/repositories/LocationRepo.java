package com.example.jpa.demo.repositories;

import com.example.jpa.demo.domain.Location;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {

  List<Location> findByStateLike(String stateName);

}
