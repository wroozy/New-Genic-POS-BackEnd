package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.ProductDetailEntity;
import lk.wroozy.newgeniccomputer.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {

    List<ProductDetailEntity> findByProductEntity(ProductEntity productEntity);
}
