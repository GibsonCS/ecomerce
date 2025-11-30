package br.com.codelift.ecomerce.infrastructure.persister;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARoleRepository extends JpaRepository<RoleEntity, Integer> {
}
