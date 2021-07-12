package lk.wroozy.newgeniccomputer.service;

import lk.wroozy.newgeniccomputer.dto.request.ProductRequestDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<?> addProduct(ProductRequestDTO productRequestDTO);

    ResponseEntity<?> getAllProducts();

    ResponseEntity<?> getProduct(long productId);
}
