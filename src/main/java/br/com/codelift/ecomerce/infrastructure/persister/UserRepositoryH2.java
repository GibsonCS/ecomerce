package br.com.codelift.ecomerce.infrastructure.persister;

import br.com.codelift.ecomerce.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryH2 implements UserRepository {
   private final JPAUserRepository jpaUserRepository;

   public UserRepositoryH2(JPAUserRepository jpaUserRepository) {
      this.jpaUserRepository = jpaUserRepository;
   }

   @Override
   public Long save(String name, String login, String password) {
      UserEntity userEntity = new UserEntity(name, login, password);
      jpaUserRepository.save(userEntity);

      return userEntity.getId();
   }

   @Override
   public Optional<UserEntity> findByLogin(String login) {
      return jpaUserRepository.findByLogin(login);
   }
}
