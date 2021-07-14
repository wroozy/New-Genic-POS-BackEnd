package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.SupplyOrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplyOrderRepository extends JpaRepository<SupplyOrderEntity, String> {


}
