package br.com.codelift.ecomerce.infrastructure.http.controller;

import br.com.codelift.ecomerce.infrastructure.http.dto.CreateUserRequest;
import br.com.codelift.ecomerce.usecase.CreateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
   private final CreateUser createUser;

   public UserController(CreateUser createUser) {
      this.createUser = createUser;
   }

   @PostMapping
   public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest) throws Exception {
      try {
         Long userID = createUser.execute(createUserRequest.name(), createUserRequest.login(), createUserRequest.email(), createUserRequest.password());
         return ResponseEntity.status(201).body(Map.of("id", userID));

      } catch (Exception e) {
         return ResponseEntity.status(400).body(Map.of("message:", e.getMessage()));
      }
   }
}
