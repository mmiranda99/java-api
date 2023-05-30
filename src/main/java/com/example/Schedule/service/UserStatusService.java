package com.example.Schedule.service;

import com.example.Schedule.entity.UserStatus;
import com.example.Schedule.models.UserStatusDTO;
import com.example.Schedule.repository.UserStatusRepository;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserStatusService {
  private final UserStatusRepository userStatusRepository;
  
  public UserStatusService(UserStatusRepository userStatusRepository) {
    this.userStatusRepository = userStatusRepository;
  }
  
  public ResponseEntity<?> createUserStatus(UserStatusDTO userStatusDTO) {
    UserStatus userStatus = new UserStatus(
        userStatusDTO.getName(),
        Collections.emptyList()
    );
    
    userStatusRepository.save(userStatus);
    return ResponseEntity.created(URI.create("Criado")).body(userStatusDTO);
  }
  
  public ResponseEntity<?> getUserStatus() {
  
    Iterable<UserStatus> userStatuses   = userStatusRepository.findAll();
    List<UserStatusDTO>  userStatusDTO = new ArrayList<>();
    userStatuses.forEach(
        userStatus -> {
          UserStatusDTO dto = new UserStatusDTO();
          dto.setId(userStatus.getId());
          dto.setName(userStatus.getName());
          userStatusDTO.add(dto);
        }
    );
    return ResponseEntity.ok().body(userStatusDTO);
  
  }
  
}
