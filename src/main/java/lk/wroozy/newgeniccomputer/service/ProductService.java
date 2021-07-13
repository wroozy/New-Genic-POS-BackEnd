package lk.wroozy.newgeniccomputer.service;

import lk.wroozy.newgeniccomputer.dto.request.ProductRequestDTO;
import lk.wroozy.newgeniccomputer.dto.request.ProductUpdateRequestDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<?> addProduct(ProductRequestDTO productRequestDTO);

    ResponseEntity<?> getAllProducts();

    ResponseEntity<?> getProduct(long productId);

    ResponseEntity<?> updateProduct(ProductUpdateRequestDTO productRequestDTO, long productId);

    ResponseEntity<?> removeProductDetail(long productDetailId);

    ResponseEntity<?> removeProduct(long productId);
}
