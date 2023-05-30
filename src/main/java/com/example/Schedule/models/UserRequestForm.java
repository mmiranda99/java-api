package com.example.Schedule.models;

import jakarta.validation.constraints.NotNull;

public class UserRequestForm {
  
  @NotNull(message = "Não recebemos nenhum AreaId")
  private Long areaId;
  
  @NotNull(message = "Não recebemos nenhum RoleId")
  private Long roleId;
  
  @NotNull(message = "Não recebemos nenhum StatusId")
  private Long statusId;
  
  @NotNull(message = "Não recebemos o campo isPrivileged")
  private boolean isPrivileged;
  
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
  
  public boolean isPrivileged() {
    return isPrivileged;
  }
  
  public void setPrivileged(boolean privileged) {
    isPrivileged = privileged;
  }
  
}
