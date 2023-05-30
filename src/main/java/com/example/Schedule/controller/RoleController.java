package com.example.Schedule.controller;

import com.example.Schedule.models.RoleDTO;
import com.example.Schedule.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/role")
public class RoleController {
  private final RoleService roleService;
  
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }
  
  @PostMapping()
  public ResponseEntity<?> createRole(@RequestBody RoleDTO roleDTO) {
    return roleService.createRole(roleDTO);
  }
  
  @GetMapping()
  public ResponseEntity<?> getRole() {
    return roleService.getRole();
  }
  
}
