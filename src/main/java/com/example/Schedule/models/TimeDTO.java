package com.example.Schedule.models;

public class TimeDTO {
  private String userId;
  private String semester;
  private String serviceTime;
  private String shift;
  private String day;
  private String serviceStart;
  private String serviceEnd;
  
  public String getUserId() {
    return userId;
  }
  
  public void setUserId(String userId) {
    this.userId = userId;
  }
  
  public String getSemester() {
    return semester;
  }
  
  public void setSemester(String semester) {
    this.semester = semester;
  }
  
  public String getServiceTime() {
    return serviceTime;
  }
  
  public void setServiceTime(String serviceTime) {
    this.serviceTime = serviceTime;
  }
  
  public String getShift() {
    return shift;
  }
  
  public void setShift(String shift) {
    this.shift = shift;
  }
  
  public String getDay() {
    return day;
  }
  
  public void setDay(String day) {
    this.day = day;
  }
  
  public String getServiceStart() {
    return serviceStart;
  }
  
  public void setServiceStart(String serviceStart) {
    this.serviceStart = serviceStart;
  }
  
  public String getServiceEnd() {
    return serviceEnd;
  }
  
  public void setServiceEnd(String serviceEnd) {
    this.serviceEnd = serviceEnd;
  }
  
}
