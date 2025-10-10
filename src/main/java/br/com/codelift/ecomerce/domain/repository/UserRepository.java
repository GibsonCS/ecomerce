package br.com.codelift.ecomerce.domain.repository;

import br.com.codelift.ecomerce.infrastructure.persister.UserEntity;

import java.util.Optional;

public interface UserRepository {
   Long save(String name, String login, String password);

   Optional<UserEntity> findByLogin(String login);
}
