package com.example.Schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "users")
public class Users {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long     id;
  
  @Column(name = "name")
  private String   name;
  
  @Column(name = "email")
  private String   email;
  
  @Column(name = "password")
  private String   password;
  
  @ManyToOne()
  @JoinColumn(name = "area_id", referencedColumnName = "id")
  private Area area;
  
  @ManyToOne()
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  private Role role;

  
  @Column(name = "code")
  private String code;
  
  @ManyToOne()
  @JoinColumn(name = "status_id", referencedColumnName = "id")
  private UserStatus userStatus;
  
  @Column(name = "is_privileged")
  private boolean isPrivileged;
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public Users(String name, String email, String password, Area area, Role role, String code, UserStatus userStatus, boolean isPrivileged) {
    this.name         = name;
    this.email        = email;
    this.password     = password;
    this.area         = area;
    this.role         = role;
    this.code         = code;
    this.userStatus   = userStatus;
    this.isPrivileged = isPrivileged;
  }
  
  public Users() {
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
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public void setCourse(Area area) {
    this.area = area;
  }
  
  public Role getRole() {
    return role;
  }
  
  public void setRole(Role role) {
    this.role = role;
  }
  
  public Area getArea() {
    return area;
  }
  
  public void setArea(Area area) {
    this.area = area;
  }
  
  public UserStatus getUserStatus() {
    return userStatus;
  }
  
  public void setUserStatus(UserStatus userStatus) {
    this.userStatus = userStatus;
  }
  
  public boolean isPrivileged() {
    return isPrivileged;
  }
  
  public void setPrivileged(boolean privileged) {
    isPrivileged = privileged;
  }
  
}
