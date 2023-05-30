package com.example.Schedule.controller;

import com.example.Schedule.models.UserStatusDTO;
import com.example.Schedule.service.UserStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user-status")
public class UserStatusController {
  
  private final UserStatusService userStatusService;
  
  public UserStatusController(UserStatusService userStatusService) {
    this.userStatusService = userStatusService;
  }
  
  @PostMapping()
  public ResponseEntity<?> createRole(@RequestBody UserStatusDTO userStatusDTO) {
    return userStatusService.createUserStatus(userStatusDTO);
  }
  
  @GetMapping()
  public ResponseEntity<?> getUserStatus() {
    return userStatusService.getUserStatus();
  }
  
}
