package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrders(Principal principal){
        LOGGER.info("request - order | getAllOrders | adminId: {}",  principal.getName());
        ResponseEntity<?> response = orderService.getAllOrders();
        LOGGER.info("response - order | getAllOrders | response: {}", response);
        return response;
    }
    @GetMapping("/getOrder")
    public ResponseEntity<?> getOrder(@RequestParam String orderId,Principal principal){
        LOGGER.info("request - order | getOrder | orderId: {} | adminId: {}", orderId, principal.getName());
        ResponseEntity<?> response = orderService.getOrder(orderId);
        LOGGER.info("response - order | getOrder | response: {}", response);
        return response;
    }
}
