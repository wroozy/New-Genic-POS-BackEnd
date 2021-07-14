package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.dto.request.OrderRequestDTO;
import lk.wroozy.newgeniccomputer.service.PlaceOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/placeOrder")
public class PlaceOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceOrderController.class);
    private final PlaceOrderService placeOrderService;

    @Autowired
    public PlaceOrderController(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO, Principal principal){
        LOGGER.info("request - placeOrder | placeOrder | orderRequestDTO: {} | adminId: {}", orderRequestDTO, principal.getName());
        ResponseEntity<?> response = placeOrderService.placeOrder(orderRequestDTO);
        LOGGER.info("response - placeOrder | placeOrder | response: {}", response);
        return response;
    }

    @GetMapping("/getProduct")
    public ResponseEntity<?> getProduct(@RequestParam String productCode,Principal principal){
        LOGGER.info("request - placeOrder | getProduct | productCode: {} | adminId: {}", productCode, principal.getName());
        ResponseEntity<?> response = placeOrderService.getProduct(productCode);
        LOGGER.info("response - placeOrder | getProduct | response: {}", response);
        return response;
    }
}
