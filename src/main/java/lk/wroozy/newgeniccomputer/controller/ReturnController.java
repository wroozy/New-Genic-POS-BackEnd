package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.dto.request.ReturnRequestDTO;
import lk.wroozy.newgeniccomputer.service.ReturnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/return")
public class ReturnController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReturnController.class);
    private ReturnService returnService;

    @Autowired
    public ReturnController(ReturnService returnService) {
        this.returnService = returnService;
    }

    @PostMapping("/placeReturn")
    public ResponseEntity<?> placeReturn(@RequestBody ReturnRequestDTO returnRequestDTO, Principal principal) {
        LOGGER.info("request - return | placeReturn | returnRequestDTO: {} | adminId: {}", returnRequestDTO, principal.getName());
        ResponseEntity<?> response = returnService.placeReturn(returnRequestDTO);
        LOGGER.info("response - return | placeReturn | response: {}", response);
        return response;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllReturn(Principal principal) {
        LOGGER.info("request - return | getAllReturn | adminId: {}", principal.getName());
        ResponseEntity<?> response = returnService.getAllReturns();
        LOGGER.info("response - return | getAllReturn | response: {}", response);
        return response;
    }

    @GetMapping("/getReturn")
    public ResponseEntity<?> getReturn(@RequestParam long returnId, Principal principal) {
        LOGGER.info("request - return | getAllReturn | returnId: {} | adminId: {}", returnId, principal.getName());
        ResponseEntity<?> response = returnService.getReturn(returnId);
        LOGGER.info("response - return | getAllReturn | response: {}", response);
        return response;
    }
}
