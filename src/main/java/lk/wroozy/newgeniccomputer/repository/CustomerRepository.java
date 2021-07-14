package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
