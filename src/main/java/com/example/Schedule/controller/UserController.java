package com.example.Schedule.controller;

import com.example.Schedule.models.EditUserDTO;
import com.example.Schedule.models.RegisterDTO;
import com.example.Schedule.models.UserLoginDTO;
import com.example.Schedule.models.UserRequestForm;
import com.example.Schedule.service.UserService;
import jakarta.validation.Valid;
import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
  
  private final UserService userService;
  
  public UserController(UserService userService) {
    this.userService = userService;
  }
  
  @PostMapping()
  public ResponseEntity<?> createUser(@Valid @RequestBody RegisterDTO registerDTO,
                                      BindingResult result) {
    if (result.hasErrors()) {
      List<String> errors = new java.util.ArrayList<>(Collections.emptyList());
      result.getAllErrors().forEach(objectError -> errors.add(objectError.getDefaultMessage()));
      return ResponseEntity.badRequest().body(errors);
    }
    return userService.create(registerDTO);
  }
  
  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLoginDTO, BindingResult result) {
    if (result.hasErrors()) {
      List<String> errors = new java.util.ArrayList<>(Collections.emptyList());
      result.getAllErrors().forEach(objectError -> errors.add(objectError.getDefaultMessage()));
      return ResponseEntity.badRequest().body(errors);
    }
    return userService.login(userLoginDTO);
  }
  
  @GetMapping()
  public ResponseEntity<?> getUsers(@RequestParam("areaId") Long areaId,
                                    @RequestParam("isPrivileged") String isPrivileged,
                                    @RequestParam("roleId") Long roleId) {
    return userService.listUsers(areaId, roleId, isPrivileged);
  }
  
  @PutMapping()
  public ResponseEntity<?> editUser(@Valid @RequestBody EditUserDTO editUserDTO,
                                    BindingResult result) {
    if (result.hasErrors()) {
      List<String> errors = new java.util.ArrayList<>(Collections.emptyList());
      result.getAllErrors().forEach(objectError -> errors.add(objectError.getDefaultMessage()));
      return ResponseEntity.badRequest().body(errors);
    }
    return userService.edit(editUserDTO);
  }
  
}