package br.com.codelift.ecomerce.infrastructure.persister;

import br.com.codelift.ecomerce.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepositoryH2 implements UserRepository {
   private final JPAUserRepository jpaUserRepository;
   private final JPARoleRepository jpaRoleRepository;

   public UserRepositoryH2(JPAUserRepository jpaUserRepository, JPARoleRepository jpaRoleRepository) {
      this.jpaUserRepository = jpaUserRepository;
      this.jpaRoleRepository = jpaRoleRepository;
   }

   @Override
   public Long save(String name, String login, String email, String password) {
      UserEntity userEntity = new UserEntity(name, login, email, password);

      RoleEntity roleEntity = new RoleEntity();
      roleEntity.setRole("default");

      Set<RoleEntity> roles = new HashSet<>();
      roles.add(roleEntity);

      userEntity.setRoles(roles);

      jpaRoleRepository.save(roleEntity);

      jpaUserRepository.save(userEntity);

      return userEntity.getId();
   }

   @Override
   public Optional<UserEntity> findByLogin(String login) {
      return jpaUserRepository.findByLogin(login);
   }
}
