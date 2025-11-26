package br.com.codelift.ecomerce.domain.entity;

public class User {
   private String name;
   private String login;
   private String password;
   private String email;

   public User (String name, String login, String email, String password  ) throws Exception {
         if(name.length() < 3) throw new Exception("The name must be 3 or more character");

         this.name = name;
         this.login = login;
         this.password = password;
   }

   public String getName() {
      return name;
   }

   public String getLogin() {
      return login;
   }

   public String getPassword() {
      return password;
   }

   public String getEmail() {
      return email;
   }
}
