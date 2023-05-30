package com.example.Schedule.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersDTO {
  
  public Long    id;
  public String  name;
  public String  code;
  public String  email;
  public Long    areaId;
  public String  areaName;
  public Long    roleId;
  public String  roleName;
  public Long    statusId;
  public String  statusName;
  @JsonProperty("isPrivileged")
  public boolean isPrivileged;
  
  public UsersDTO(Long id, String name, String code, String email, Long areaId, String areaName, Long roleId, String roleName, Long statusId, String statusName, boolean isPrivileged) {
    this.id           = id;
    this.name         = name;
    this.code         = code;
    this.email        = email;
    this.areaId       = areaId;
    this.areaName     = areaName;
    this.roleId       = roleId;
    this.roleName     = roleName;
    this.statusId     = statusId;
    this.statusName   = statusName;
    this.isPrivileged = isPrivileged;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getAreaName() {
    return areaName;
  }
  
  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }
  
  public String getRoleName() {
    return roleName;
  }
  
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public Long getAreaId() {
    return areaId;
  }
  
  public void setAreaId(Long areaId) {
    this.areaId = areaId;
  }
  
  public Long getRoleId() {
    return roleId;
  }
  
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
  
  public Long getStatusId() {
    return statusId;
  }
  
  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }
  
  public String getStatusName() {
    return statusName;
  }
  
  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }
  
  public boolean isPrivileged() {
    return isPrivileged;
  }
  
  public void setPrivileged(boolean privileged) {
    isPrivileged = privileged;
  }
  
}
