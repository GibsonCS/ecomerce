package br.com.codelift.ecomerce.controller.dto;

import java.util.Objects;

public class CreateUserRequest {

   private String name;
   private String login;
   private String password;

   public CreateUserRequest(String name, String login, String password){
      this.name = name;
      this.login= login;
      this.password = password;
   }

   @Override
   public String toString() {
      return "UserDTO {" +
              "name='" + name + '\'' +
              ", login='" + login + '\'' +
              ", passowrd='" + password + '\'' +
              '}';
   }

   public String getName() {
      return name;
   }

   public String getLogin() {
      return login;
   }

   public String getPassowrd() {
      return password;
   }

   @Override
   public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      CreateUserRequest that = (CreateUserRequest) o;
      return Objects.equals(name, that.name) && Objects.equals(login, that.login) && Objects.equals(password, that.password);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, login, password);
   }
}
