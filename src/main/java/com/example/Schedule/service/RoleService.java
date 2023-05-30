package com.example.Schedule.service;

import com.example.Schedule.entity.Area;
import com.example.Schedule.entity.Role;
import com.example.Schedule.models.AreaDTO;
import com.example.Schedule.models.RoleDTO;
import com.example.Schedule.repository.RoleRepository;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  private final RoleRepository roleRepository;
  
  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }
  
  public ResponseEntity<?> createRole(RoleDTO roleDTO) {
  
    Role role = new Role(
        roleDTO.getName(),
        Collections.emptyList()
    );
  
    Optional<Role> roleOptional = roleRepository.findByName(roleDTO.getName());
    
    if (roleOptional.isPresent()) {
      return ResponseEntity.badRequest().body("Esse role já foi cadastrado");
    }
    
    roleRepository.save(role);
    
    return ResponseEntity.created(URI.create("Criado")).body(roleDTO);
  }
  
  public ResponseEntity<?> getRole() {
    Iterable<Role> roles   = roleRepository.findAll();
    List<RoleDTO>      roleDTO = new ArrayList<>();
    roles.forEach(
        role -> {
          RoleDTO dto = new RoleDTO();
          dto.setId(role.getId());
          dto.setName(role.getName());
          roleDTO.add(dto);
        }
    );
    return ResponseEntity.ok().body(roleDTO);
  }
  
}
