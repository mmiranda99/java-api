//package com.example.Schedule.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity(name = "est_schedule_time")
//public class Time {
//
//  @Id
//  @Column(name = "tim_id")
//  private String id;
//
//  @Column(name = "tim_semester")
//  private String semester;
//
//  @Column(name = "tim_service_time")
//  private String serviceTime;
//
//  @Column(name = "tim_shift")
//  private String shift;
//
//  @Column(name = "tim_day")
//  private String day;
//
//  @Column(name = "tim_service_start")
//  private String serviceStart;
//
//  @Column(name = "tim_service_end")
//  private String serviceEnd;
//
//  @ManyToOne()
//  @JoinColumn(name = "tim_usr_id", referencedColumnName = "id")
//  private Users users;
//
//  public Time(String id, String semester, String serviceTime, String shift, String day,
//              String serviceStart, String serviceEnd, Users users) {
//    this.id           = id;
//    this.semester     = semester;
//    this.serviceTime  = serviceTime;
//    this.shift        = shift;
//    this.day          = day;
//    this.serviceStart = serviceStart;
//    this.serviceEnd   = serviceEnd;
//    this.users        = users;
//  }
//
//  public Time() {
//  }
//
//  public String getId() {
//    return id;
//  }
//
//  public void setId(String id) {
//    this.id = id;
//  }
//
//  public String getSemester() {
//    return semester;
//  }
//
//  public void setSemester(String semester) {
//    this.semester = semester;
//  }
//
//  public String getServiceTime() {
//    return serviceTime;
//  }
//
//  public void setServiceTime(String serviceTime) {
//    this.serviceTime = serviceTime;
//  }
//
//  public String getShift() {
//    return shift;
//  }
//
//  public void setShift(String shift) {
//    this.shift = shift;
//  }
//
//  public String getDay() {
//    return day;
//  }
//
//  public void setDay(String day) {
//    this.day = day;
//  }
//
//  public String getServiceStart() {
//    return serviceStart;
//  }
//
//  public void setServiceStart(String serviceStart) {
//    this.serviceStart = serviceStart;
//  }
//
//  public String getServiceEnd() {
//    return serviceEnd;
//  }
//
//  public void setServiceEnd(String serviceEnd) {
//    this.serviceEnd = serviceEnd;
//  }
//
//  public Users getUser() {
//    return users;
//  }
//
//  public void setUser(Users users) {
//    this.users = users;
//  }
//
//}
