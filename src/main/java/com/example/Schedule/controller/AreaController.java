package com.example.Schedule.controller;

import com.example.Schedule.models.AreaDTO;
import com.example.Schedule.service.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/area")
public class AreaController {
  private final AreaService areaService;
  
  public AreaController(AreaService areaService) {
    this.areaService = areaService;
  }
  
  @PostMapping()
  public ResponseEntity<?> createArea(@RequestBody AreaDTO areaDTO) {
    return areaService.createArea(areaDTO);
  }
  
  @GetMapping()
  public ResponseEntity<?> getArea() {
    return areaService.getArea();
  }
  
}
