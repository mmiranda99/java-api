package com.example.Schedule.models;

import jakarta.validation.constraints.NotEmpty;

public class AreaDTO {
  
  private Long id;
  
  @NotEmpty(message = "Necessário informar a área")
  private String name;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
}
