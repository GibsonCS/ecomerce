package br.com.codelift.ecomerce.infrastructure.persister;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAUserRepository extends JpaRepository<UserEntity, String> {
   Optional<UserEntity> findByLogin(String login);
}
