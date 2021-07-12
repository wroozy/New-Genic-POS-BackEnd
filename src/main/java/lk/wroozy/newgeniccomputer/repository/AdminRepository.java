package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity,String> {

    AdminEntity findByUsername(String username);

    Optional<AdminEntity> findByUuid(String uuid);

}
