package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
