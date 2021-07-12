package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    Optional<SupplierEntity> findByName(String name);

    Optional<SupplierEntity> findBySupplierUuid(String id);
}
