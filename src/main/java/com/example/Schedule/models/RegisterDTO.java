package com.example.Schedule.models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RegisterDTO {
  @NotEmpty(message = "Nome não pode estar vazio")
  private String   name;
  
  @Email(message = "O campo 'email' deve ser um endereço de e-mail válido.")
  private String   email;
  
  @NotEmpty(message = "Senha não pode estar vazia")
  private String   password;
  
  @NotNull(message = "Não recebemos nenhum RoleId")
  private Long roleId;
  
  @NotNull(message = "Não recebemos nenhum AreaId")
  private Long areaId;
  
  @NotNull(message = "Não recebemos nenhum StatusId")
  private Long statusId;
  
  @Pattern(regexp = "\\d{12}", message = "Matrícula inválida.")
  private String   code;
  
  private boolean  isPrivileged;
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
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
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Long getRoleId() {
    return roleId;
  }
  
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
  
  public Long getAreaId() {
    return areaId;
  }
  
  public void setAreaId(Long areaId) {
    this.areaId = areaId;
  }
  
  public boolean isPrivileged() {
    return isPrivileged;
  }
  
  public void setPrivileged(boolean privileged) {
    isPrivileged = privileged;
  }
  
  public Long getStatusId() {
    return statusId;
  }
  
  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }
  
}
