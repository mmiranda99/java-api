package com.example.Schedule.repository;

import com.example.Schedule.entity.Area;
import com.example.Schedule.entity.Role;
import com.example.Schedule.entity.UserStatus;
import com.example.Schedule.entity.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
  
  Optional<Users> findByEmail(String email);
  
  Optional<Users> findByCodeOrEmail(String code, String email);
  
  Optional<List<Users>> findByArea(Area area);
  
  @Query("SELECT users FROM users users WHERE users.area = :area and users.role = :role and users" +
      ".userStatus = :userStatus and users.isPrivileged = :privileged")
  Optional<List<Users>> findAllByAreaOrRoleOrUserStatusOrPrivileged(@Param("area") Area area,
                                                                    @Param("role") Role role,
                                                                    @Param("userStatus") UserStatus userStatus,
                                                                    @Param("privileged") boolean privileged);
  
}
