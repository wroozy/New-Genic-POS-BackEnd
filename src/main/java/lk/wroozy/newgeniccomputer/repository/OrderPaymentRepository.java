package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.OrderPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPaymentRepository extends JpaRepository<OrderPaymentEntity, Long> {
}
