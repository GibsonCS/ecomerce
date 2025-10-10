package br.com.codelift.ecomerce.usecase;

import br.com.codelift.ecomerce.domain.entity.User;
import br.com.codelift.ecomerce.domain.repository.UserRepository;
import br.com.codelift.ecomerce.infrastructure.persister.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateUser {
   private final UserRepository userRepository;

   public CreateUser(UserRepository userRepository) throws Exception {
      this.userRepository = userRepository;
   }

   public Long execute(String name, String login, String password) throws Exception {
      Optional<UserEntity> userFound = this.userRepository.findByLogin(login);
      if(userFound.isPresent()) throw  new Exception("Username already exists");

      User user = new User(name, login, password);

      return this.userRepository.save(user.getName(), user.getLogin(), user.getPassword());
   }
}
