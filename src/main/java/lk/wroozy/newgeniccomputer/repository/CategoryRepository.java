package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByCategory(String category);
}
