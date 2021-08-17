package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.dto.request.SupplyOrderRequestDTO;
import lk.wroozy.newgeniccomputer.service.SupplyOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/supplyOrder")
public class SupplyOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplyOrderController.class);
    private final SupplyOrderService supplyOrderService;

    @Autowired
    public SupplyOrderController(SupplyOrderService supplyOrderService) {
        this.supplyOrderService = supplyOrderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeSupplyOrder(@RequestBody SupplyOrderRequestDTO supplyOrderRequestDTO, Principal principal) {
        LOGGER.info("request - supplyOrder | placeSupplyOrder | supplyOrderRequest: {} | adminId: {}", supplyOrderRequestDTO, principal.getName());
        ResponseEntity<?> response = supplyOrderService.placeOrder(supplyOrderRequestDTO);
        LOGGER.info("response - supplyOrder | placeSupplyOrder | response: {}", response);
        return response;
    }

    @GetMapping("/getAllSupplyReport")
    public ResponseEntity<?> getAllSupplyReport(Principal principal, @RequestParam int index, @RequestParam int size) {
        LOGGER.info("request - supplyOrder | getAllSupplyReport | adminId: {} | index: {} | size: {}", principal.getName(), index, size);
        ResponseEntity<?> response = supplyOrderService.getAllSupplyReport(index, size);
        LOGGER.info("response - supplyOrder | getAllSupplyReport | response: {}", response);
        return response;
    }

    @GetMapping("/getSupplyOrderReport")
    public ResponseEntity<?> getSupplyOrderReport(Principal principal, @RequestParam String supplyOrderId) {
        LOGGER.info("request - supplyOrder | getSupplyOrderReport | adminId: {} | supplyOrderId: {}", principal.getName(), supplyOrderId);
        ResponseEntity<?> response = supplyOrderService.getSupplyOrder(supplyOrderId);
        LOGGER.info("response - supplyOrder | getSupplyOrderReport | response: {}", response);
        return response;
    }
}
