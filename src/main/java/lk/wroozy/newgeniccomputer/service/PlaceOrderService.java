package lk.wroozy.newgeniccomputer.service;

import lk.wroozy.newgeniccomputer.dto.request.OrderRequestDTO;
import org.springframework.http.ResponseEntity;

public interface PlaceOrderService {

    ResponseEntity<?> placeOrder(OrderRequestDTO orderRequestDTO);

    ResponseEntity<?> getProduct(String productCode);

}
