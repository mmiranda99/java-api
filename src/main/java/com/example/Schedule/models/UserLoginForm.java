package com.example.Schedule.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginForm {
  
  private Long  id;
  private String  name;
  private String  email;
  private String  roleName;
  private Long  roleId;
  private String  areaName;
  private Long  areaId;
  private String  code;
  @JsonProperty("isPrivileged")
  private boolean isPrivileged;
  private String statusName;
  private Long   statusId;
  
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
  
  public String getRoleName() {
    return roleName;
  }
  
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  
  
  public UserLoginForm(Long id, String name, String email, String roleName, Long roleId,
                       String areaName, Long areaId, String code, boolean isPrivileged,
                       String statusName, Long statusId) {
    this.id           = id;
    this.name         = name;
    this.email        = email;
    this.roleName     = roleName;
    this.roleId       = roleId;
    this.areaName     = areaName;
    this.areaId       = areaId;
    this.code         = code;
    this.isPrivileged = isPrivileged;
    this.statusName = statusName;
    this.statusId   = statusId;
  }
  
  public Long getRoleId() {
    return roleId;
  }
  
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
  
  public String getAreaName() {
    return areaName;
  }
  
  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }
  
  public Long getAreaId() {
    return areaId;
  }
  
  public void setAreaId(Long areaId) {
    this.areaId = areaId;
  }
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public boolean isPrivileged() {
    return isPrivileged;
  }
  
  public void setPrivileged(boolean privileged) {
    isPrivileged = privileged;
  }
  
  public String getStatusName() {
    return statusName;
  }
  
  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }
  
  public Long getStatusId() {
    return statusId;
  }
  
  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }
  
}
