package com.example.Schedule.repository;

import com.example.Schedule.entity.UserStatus;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserStatusRepository extends CrudRepository<UserStatus, Long> {
  
  Optional<UserStatus> findByName(String name);
  
}
