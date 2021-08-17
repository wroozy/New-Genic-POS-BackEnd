package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.dto.request.SupplierRequestDTO;
import lk.wroozy.newgeniccomputer.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/supply")
public class SupplierController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/addNew")
    public ResponseEntity<?> addSupplier(@RequestBody SupplierRequestDTO supplierRequestDTO,Principal principal) {
        LOGGER.info("request - supplier | addSupplier | supplierRequestDTO: {} | adminId: {}", supplierRequestDTO, principal.getName());
        ResponseEntity<?> supplier = supplierService.addSupplier(supplierRequestDTO, principal.getName());
        LOGGER.info("response - supplier | addSupplier | supplier: {}", supplier.getBody());
        return supplier;
    }

//    SupplierRequestDTO cannot be null any attribute when frontend send to me 
    @PutMapping("/update")
    public ResponseEntity<?> updateSupplier(@RequestBody SupplierRequestDTO supplierRequestDTO, @RequestParam String supplierId, Principal principal) {
        LOGGER.info("request - supplier | updateSupplier | supplierRequestDTO: {} | supplierId: {} | adminId: {}", supplierRequestDTO, supplierId, principal.getName());
        ResponseEntity<?> responseEntity = supplierService.updateSupplier(supplierRequestDTO, supplierId);
        LOGGER.info("response - supplier | updateSupplier | response: {}", responseEntity.getBody());
        return responseEntity;
    }

    @DeleteMapping("/removeSupplier")
    public ResponseEntity<?> removeSupplier(@RequestParam String supplierId, Principal principal) {
        LOGGER.info("request - supplier | removeSupplier | supplierId: {} | adminId: {}", supplierId, principal.getName());
        ResponseEntity<?> responseEntity = supplierService.removeSupplier(supplierId);
        LOGGER.info("response - supplier | removeSupplier | response: {}", responseEntity.getBody());
        return responseEntity;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllSuppliers(Principal principal) {
        LOGGER.info("request - supplier | getAllSuppliers | AdminId: {}", principal.getName());
        ResponseEntity<?> allSuppliers = supplierService.getAllSuppliers();
        LOGGER.info("response - supplier | getAllSuppliers | response: {}", "All Suppliers");
        return allSuppliers;
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<?> getSupplier(@PathVariable String supplierId, Principal principal) {
        LOGGER.info("request - supplier | getSuppliers | supplierId: {} | AdminId: {}", supplierId, principal.getName());
        ResponseEntity<?> supplier = supplierService.getSupplier(supplierId);
        LOGGER.info("response - supplier | getSuppliers | supplier: {}", supplier);
        return supplier;
    }
}
