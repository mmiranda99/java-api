package com.example.Schedule.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class UserLoginDTO {
  
  @Email(message = "O campo 'email' deve ser um endereço de e-mail válido.")
  @NotEmpty(message = "Code/Email inválido")
  @NotBlank(message = "Code/Email inválido")
  private String email;
  
  @NotEmpty(message = "Senha inválida")
  @NotBlank(message = "Senha inválida")
  private String password;
  
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
  
}
