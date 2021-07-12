package lk.wroozy.newgeniccomputer.service;

import lk.wroozy.newgeniccomputer.dto.request.SupplierRequestDTO;
import org.springframework.http.ResponseEntity;

public interface SupplierService {

    ResponseEntity<?> addSupplier(SupplierRequestDTO supplierRequestDTO, String adminId);

    ResponseEntity<?> removeSupplier(String supplierId);

    ResponseEntity<?> getAllSuppliers();

    ResponseEntity<?> getSupplier(String supplierId);

    ResponseEntity<?> updateSupplier(SupplierRequestDTO supplierRequestDTO,String supplierId);

}
