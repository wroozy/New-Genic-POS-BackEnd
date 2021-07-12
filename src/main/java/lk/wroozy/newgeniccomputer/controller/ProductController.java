package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.dto.request.ProductRequestDTO;
import lk.wroozy.newgeniccomputer.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO productRequestDTO, Principal principal) {
        LOGGER.info("request - product | addProduct | productRequestDTO: {} | adminId: {}", productRequestDTO, principal.getName());
        ResponseEntity<?> response = productService.addProduct(productRequestDTO);
        LOGGER.info("response - product | addProduct | response: {}", response);
        return response;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getALlProduct(Principal principal) {
        LOGGER.info("request - product | getAllProduct | adminId: {}", principal.getName());
        ResponseEntity<?> response = productService.getAllProducts();
        LOGGER.info("response - product | addProduct | response: {}", "Get all products");
        return response;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getALlProduct(@PathVariable long productId, Principal principal) {
        LOGGER.info("request - product | getAllProduct | productId: {} | adminId: {}", productId, principal.getName());
        ResponseEntity<?> response = productService.getProduct(productId);
        LOGGER.info("response - product | addProduct | response: {}", response);
        return response;
    }

}
