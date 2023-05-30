package com.example.Schedule.service;

import com.example.Schedule.entity.Area;
import com.example.Schedule.entity.Users;
import com.example.Schedule.models.AreaDTO;
import com.example.Schedule.models.CourseDTO;
import com.example.Schedule.models.UserInfoDTO;
import com.example.Schedule.repository.AreaRepository;
import com.example.Schedule.repository.UserRepository;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AreaService {
  private final AreaRepository areaRepository;
  private final UserRepository userRepository;
  
  public AreaService(AreaRepository areaRepository, UserRepository userRepository) {
    this.areaRepository = areaRepository;
    this.userRepository = userRepository;
  }
  
  public ResponseEntity<?> createArea(AreaDTO areaDTO) {
    
    Area area = new Area(
        areaDTO.getName(),
        Collections.emptyList()
    );
    
    Optional<Area> areaOptional = areaRepository.findByName(areaDTO.getName());
    
    if (areaOptional.isPresent()) {
      return ResponseEntity.badRequest().body("Esse curso já foi cadastrado");
    }
    
    areaRepository.save(area);
    return ResponseEntity.created(URI.create("Criado")).body(areaDTO);
  }
  
  public ResponseEntity<?> getArea() {
    Iterable<Area> areas = areaRepository.findAll();
    List<AreaDTO> areaDTO = new ArrayList<>();
    areas.forEach(
        area -> {
          AreaDTO dto = new AreaDTO();
          dto.setId(area.getId());
          dto.setName(area.getName());
          areaDTO.add(dto);
        }
    );
    return ResponseEntity.ok().body(areaDTO);
  }
  
}
