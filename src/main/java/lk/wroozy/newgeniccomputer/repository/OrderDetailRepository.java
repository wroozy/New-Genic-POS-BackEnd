package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {

    @Query(value = "SELECT * , COUNT(*) AS magnitude FROM order_detail GROUP BY fk_order_id ORDER BY magnitude DESC LIMIT 1",
            nativeQuery = true)
    OrderDetailEntity getMostSellingProduct();
}
