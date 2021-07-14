package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByProductCode(String productCode);
}
