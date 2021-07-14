package lk.wroozy.newgeniccomputer.repository;

import lk.wroozy.newgeniccomputer.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query(value = "SELECT * FROM orders WHERE MONTH(date) = MONTH(CURRENT_DATE()) AND YEAR(date) = YEAR(CURRENT_DATE())",
    nativeQuery = true)
    List<OrderEntity> getThisMonthOrders();

    @Query(value = "SELECT * FROM orders WHERE MONTH(date) = :month AND YEAR(date) = :year",
            nativeQuery = true)
    List<OrderEntity> getMonthOrders(@Param("month") int month, @Param("year") int year);
}
