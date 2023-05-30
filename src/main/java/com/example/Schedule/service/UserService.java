package com.example.Schedule.service;

import com.example.Schedule.entity.Area;
import com.example.Schedule.entity.Role;
import com.example.Schedule.entity.UserStatus;
import com.example.Schedule.entity.Users;
import com.example.Schedule.models.EditUserDTO;
import com.example.Schedule.models.RegisterDTO;
import com.example.Schedule.models.UserLoginDTO;
import com.example.Schedule.models.UserLoginForm;
import com.example.Schedule.models.UsersDTO;
import com.example.Schedule.repository.AreaRepository;
import com.example.Schedule.repository.RoleRepository;
import com.example.Schedule.repository.UserRepository;
import com.example.Schedule.repository.UserStatusRepository;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  private final UserRepository userRepository;
  private final AreaRepository areaRepository;
  private final RoleRepository roleRepository;
  private final UserStatusRepository userStatusRepository;
  
  public UserService(UserRepository userRepository, AreaRepository areaRepository, RoleRepository roleRepository, UserStatusRepository userStatusRepository) {
    this.userRepository       = userRepository;
    this.areaRepository       = areaRepository;
    this.roleRepository       = roleRepository;
    this.userStatusRepository = userStatusRepository;
  }
  
  public ResponseEntity<?> create(RegisterDTO registerDTO) {
    Optional<Users> userOptional = userRepository.findByCodeOrEmail(registerDTO.getCode(),
        registerDTO.getEmail()).stream().findFirst();
    
    if (userOptional.isPresent()) {
      return ResponseEntity.badRequest().body("Já existe um usuário associado a esta matricula ou" +
          " e-mail");
    }
    
    Optional<Role> roleOptional   = roleRepository.findById(registerDTO.getRoleId());
    Optional<Area> areaOptional = areaRepository.findById(registerDTO.getAreaId());
    Optional<UserStatus> userStatusOptional = userStatusRepository.findById(registerDTO.getStatusId());
    String passwordEncoded = encode(registerDTO.getPassword());
    
    Users users = new Users(
        registerDTO.getName(),
        registerDTO.getEmail(),
        passwordEncoded,
        areaOptional.orElse(null),
        roleOptional.orElse(null),
        registerDTO.getCode(),
        userStatusOptional.orElse(null),
        registerDTO.isPrivileged()
    );
    
    userRepository.save(users);
    
    return ResponseEntity.created(URI.create("Criado")).body(registerDTO);
  }
  
  public ResponseEntity<?> login(UserLoginDTO userLoginDTO) {
    Optional<Users> userOptional = userRepository.findByEmail(userLoginDTO.getEmail());
    
    if (userOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    if (!Objects.equals(userOptional.get().getPassword(), encode(userLoginDTO.getPassword()))) {
      return ResponseEntity.badRequest().body("Senha incorreta");
    }
    
    String areaName = null;
    Long areaId = null;
    if (!userOptional.get().getRole().getName().equals("ADMIN")) {
      areaName = userOptional.get().getArea().getName();
      areaId = userOptional.get().getArea().getId();
    }
    
    UserLoginForm userLoginForm = new UserLoginForm(
        userOptional.get().getId(),
        userOptional.get().getName(),
        userOptional.get().getEmail(),
        userOptional.get().getRole().getName(),
        userOptional.get().getRole().getId(),
        areaName,
        areaId,
        userOptional.get().getCode(),
        userOptional.get().isPrivileged(),
        userOptional.get().getUserStatus().getName(),
        userOptional.get().getUserStatus().getId()
    );
    
    return ResponseEntity.ok(userLoginForm);
    
  }
  
  public static String encode(String input) {
    try {
      MessageDigest md   = MessageDigest.getInstance("MD5");
      byte[]    hash      = md.digest(input.getBytes());
      Formatter formatter = new Formatter();
      
      for (byte b : hash) {
        formatter.format("%02x", b);
      }
      
      String encodedString = formatter.toString();
      formatter.close();
      
      return encodedString;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  
  public ResponseEntity<?> listUsers(Long areaId, Long roleId, String isPrivileged) {
    
    Optional<Role> role = roleRepository.findByName("COORDINATOR");
    if (isPrivileged.equals("true") && (Objects.equals(roleId, role.get().getId()))) {
      List<UsersDTO>  usersDTOList = new java.util.ArrayList<>(Collections.emptyList());
      Iterable<Users> otherUsers = userRepository.findAll();
      otherUsers.forEach(user -> {
        UsersDTO usersDTO = new UsersDTO(
            user.getId(),
            user.getName(),
            user.getCode(),
            user.getEmail(),
            user.getArea().getId(),
            user.getArea().getName(),
            user.getRole().getId(),
            user.getRole().getName(),
            user.getUserStatus().getId(),
            user.getUserStatus().getName(),
            user.isPrivileged()
        );
        usersDTOList.add(usersDTO);
      });
      return ResponseEntity.ok(usersDTOList);
    } else {
      Optional<List<Users>> users;
      users        =
          userRepository.findByArea(areaRepository.findById(areaId).orElse(null));
      List<UsersDTO>  usersDTOList = new ArrayList<>(Collections.emptyList());
      if (users.isPresent()) {
        users.get().forEach(user -> {
          if (user.getRole().getName().equals("STUDENT")) {
            UsersDTO usersDTO = new UsersDTO(
                user.getId(),
                user.getName(),
                user.getCode(),
                user.getEmail(),
                user.getArea().getId(),
                user.getArea().getName(),
                user.getRole().getId(),
                user.getRole().getName(),
                user.getUserStatus().getId(),
                user.getUserStatus().getName(),
                user.isPrivileged()
            );
            usersDTOList.add(usersDTO);
          }

        });
        return ResponseEntity.ok(usersDTOList);
      }
      return ResponseEntity.badRequest().body("Não encontramos nenhum usuário para os parâmetros " +
          "enviados");
    }
  }
  
  public ResponseEntity<?> edit(EditUserDTO registerDTO) {
    Optional<Users> users = userRepository.findById(registerDTO.getId());
    Optional<Area> areaOptional = areaRepository.findById(registerDTO.getAreaId());
    Optional<Role> roleOptional = roleRepository.findById(registerDTO.getRoleId());
    Optional<UserStatus> statusOptional = userStatusRepository.findById(registerDTO.getStatusId());
    if (users.isPresent()) {
      users.get().setName(registerDTO.getName());
      users.get().setCode(registerDTO.getCode());
      users.get().setEmail(registerDTO.getEmail());
      users.get().setPassword(encode(users.get().getPassword()));
      users.get().setArea(areaOptional.orElse(null));
      users.get().setRole(roleOptional.orElse(null));
      users.get().setUserStatus(statusOptional.orElse(null));
      userRepository.save(users.get());
      return ResponseEntity.ok(registerDTO);
    }
    return ResponseEntity.badRequest().body("Não foi encontrado nenhum usuário com este ID para " +
        "editar");
  }
  
}
