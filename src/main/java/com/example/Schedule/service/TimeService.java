//package com.example.Schedule.service;
//
//import com.example.Schedule.entity.Time;
//import com.example.Schedule.entity.Users;
//import com.example.Schedule.models.TimeDTO;
//import com.example.Schedule.models.UserDTO;
//import com.example.Schedule.repository.TimeRepository;
//import com.example.Schedule.repository.UserRepository;
//import java.net.URI;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TimeService {
//
//  private final TimeRepository timeRepository;
//  private final UserRepository userRepository;
//
//  public TimeService(TimeRepository timeRepository, UserRepository userRepository) {
//    this.timeRepository = timeRepository;
//    this.userRepository = userRepository;
//  }
//
//  public ResponseEntity<?> createTime(TimeDTO timeDTO) {
//    Optional<Users> user = userRepository.findById(timeDTO.getUserId());
//
//    if (user.isEmpty()) {
//      return ResponseEntity.notFound().build();
//    }
//
//    Time time = new Time(
//        UUID.randomUUID().toString(),
//        timeDTO.getSemester(),
//        timeDTO.getServiceTime(),
//        timeDTO.getShift(),
//        timeDTO.getDay(),
//        timeDTO.getServiceStart(),
//        timeDTO.getServiceEnd(),
//        user.get()
//    );
//
//    timeRepository.save(time);
//
//    return ResponseEntity.created(URI.create("Created")).body(timeDTO);
//  }
//
//
//  public ResponseEntity<?> availableDays(UserDTO userDTO) {
//    Optional<Users> user = userRepository.findById(userDTO.getUserId());
//
//    if (user.isEmpty()) {
//      return ResponseEntity.notFound().build();
//    }
//
//    LocalDate localDateTime = LocalDate.now();
//
//    Month  month = localDateTime.getMonth();
//    int    year  = localDateTime.getYear();
//    String semester;
//    if (month.getValue() <= Month.JUNE.getValue()) {
//      semester = year + ".1";
//    } else {
//      semester = year + ".2";
//    }
//
//    Optional<List<Time>> time = timeRepository.findBySemesterAndUser(semester, user.get());
//
//    if (time.isEmpty()) {
//      return ResponseEntity.notFound().build();
//    }
//
//    List<Date> availableDays = new ArrayList<>();
//    Calendar   calendar      = Calendar.getInstance();
//
//    calendar.set(localDateTime.getYear(), Calendar.JANUARY, 1);
//
//    int firstHalfEndMonth = Calendar.JUNE;
//    for (int i = 0; i < time.get().size(); i++) {
//      System.out.println(i);
//      System.out.println(time.get().get(i).getDay());
//      while (calendar.get(Calendar.MONTH) <= firstHalfEndMonth) {
//        extracted(time.get().get(i).getDay(), availableDays, calendar);
//
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//      }
//    }
//
//
//
//
//
//    return ResponseEntity.ok().body(availableDays);
//  }
//
//  private static void extracted(String stringDay, List<Date> availableDays, Calendar calendar) {
//    switch (stringDay) {
//      case "SUNDAY":
//        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
//          Date monday = calendar.getTime();
//          availableDays.add(monday);
//        }
//      case "MONDAY":
//        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
//          Date monday = calendar.getTime();
//          availableDays.add(monday);
//        }
//      case "TUESDAY":
//        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
//          Date monday = calendar.getTime();
//          availableDays.add(monday);
//        }
//      case "WEDNESDAY":
//        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
//          Date monday = calendar.getTime();
//          availableDays.add(monday);
//        }
//      case "THURSDAY":
//        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
//          Date monday = calendar.getTime();
//          availableDays.add(monday);
//        }
//      case "FRIDAY":
//        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
//          Date monday = calendar.getTime();
//          availableDays.add(monday);
//        }
//      case "SATURDAY":
//        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
//          Date monday = calendar.getTime();
//          availableDays.add(monday);
//        }
//    }
//
//  }
//
//
//
//}
