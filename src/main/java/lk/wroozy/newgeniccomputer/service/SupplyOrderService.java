package lk.wroozy.newgeniccomputer.service;

import lk.wroozy.newgeniccomputer.dto.request.SupplyOrderRequestDTO;
import org.springframework.http.ResponseEntity;

public interface SupplyOrderService {

    ResponseEntity<?> placeOrder(SupplyOrderRequestDTO supplyOrderRequestDTO);

    ResponseEntity<?> getAllSupplyReport(int index,int size);

    ResponseEntity<?> getSupplyOrder(String supplyOrderId);
}
