//package com.example.Schedule.controller;
//
//import com.example.Schedule.models.TimeDTO;
//import com.example.Schedule.models.UserDTO;
//import com.example.Schedule.service.TimeService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/time")
//public class TimeController {
//  private final TimeService timeService;
//
//  public TimeController(TimeService timeService) {
//    this.timeService = timeService;
//  }
//
//  @PostMapping()
//  public ResponseEntity<?> createTime(@RequestBody TimeDTO timeDTO) {
//    return timeService.createTime(timeDTO);
//  }
//
//  @GetMapping("available-days")
//  public ResponseEntity<?> availableDays(@RequestBody UserDTO userDTO) {
//    return timeService.availableDays(userDTO);
//  }
//
//}
