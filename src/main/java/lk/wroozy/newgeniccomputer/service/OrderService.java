package lk.wroozy.newgeniccomputer.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<?> getAllOrders();
    ResponseEntity<?> getOrder(String orderId);
}
