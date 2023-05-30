package com.example.Schedule.repository;

import com.example.Schedule.entity.Area;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AreaRepository extends CrudRepository<Area, Long> {
  Optional<Area> findByName(String name);
}
