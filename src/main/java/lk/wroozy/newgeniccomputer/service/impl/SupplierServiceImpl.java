package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.request.SupplierRequestDTO;
import lk.wroozy.newgeniccomputer.dto.response.SupplierResponseDTO;
import lk.wroozy.newgeniccomputer.entity.AdminEntity;
import lk.wroozy.newgeniccomputer.entity.SupplierEntity;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.repository.AdminRepository;
import lk.wroozy.newgeniccomputer.repository.SupplierRepository;
import lk.wroozy.newgeniccomputer.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierServiceImpl implements SupplierService {

    private AdminRepository adminRepository;
    private SupplierRepository supplierRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SupplierServiceImpl(AdminRepository adminRepository,
                               SupplierRepository supplierRepository,
                               ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> addSupplier(SupplierRequestDTO supplierRequestDTO, String adminId) {
        try {
            if (supplierRequestDTO != null) {
                Optional<SupplierEntity> existingSupplier = supplierRepository.findByName(supplierRequestDTO.getName());
                if (existingSupplier.isPresent()) {
                    return new ResponseEntity<>("Supplier already registered", HttpStatus.CONFLICT);
                }
                Optional<AdminEntity> admin = adminRepository.findByUuid(adminId);
                if (admin.isPresent()) {
                    SupplierEntity supplierEntity = modelMapper.map(supplierRequestDTO, SupplierEntity.class);
                    supplierEntity.setSupplierUuid(UUID.randomUUID().toString());
                    supplierEntity.setAdminEntity(admin.get());

                    SupplierEntity entity = supplierRepository.save(supplierEntity);
                    if (entity != null) {
                        return new ResponseEntity<>(entity.getSupplierUuid(), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>("Supplier not saved", HttpStatus.BAD_REQUEST);
                    }
                } else {
                    return new ResponseEntity<>("Hutto Admin sign in karapan ballo", HttpStatus.UNAUTHORIZED);
                }
            } else {
                return new ResponseEntity<>("Supplier details not found", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            throw new CustomException("Failed to add supplier");
        }
    }

    @Override
    public ResponseEntity<?> removeSupplier(String supplierId) {
        try {
            if (supplierId.isEmpty()) {
                return new ResponseEntity<>("Supplier id not found", HttpStatus.BAD_REQUEST);
            }
            Optional<SupplierEntity> supplierEntity = supplierRepository.findBySupplierUuid(supplierId);
            if (supplierEntity.isPresent()) {
                supplierRepository.delete(supplierEntity.get());
                return new ResponseEntity<>("Supplier remove from system", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Supplier not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new CustomException("Failed to remove supplier");
        }
    }

    @Override
    public ResponseEntity<?> getAllSuppliers() {
        try {
            List<SupplierEntity> allSuppliers = supplierRepository.findAll();
            if (allSuppliers.isEmpty()) {
                return new ResponseEntity<>("No suppliers", HttpStatus.OK);
            }
            List<SupplierResponseDTO> allSupplierList = new ArrayList<>();
            for (SupplierEntity supplierEntity :
                    allSuppliers) {
                allSupplierList.add(modelMapper.map(supplierEntity, SupplierResponseDTO.class));
            }
            return new ResponseEntity<>(allSupplierList, HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Failed to get all suppliers");
        }
    }

    @Override
    public ResponseEntity<?> getSupplier(String supplierId) {
        try {
            if (supplierId.isEmpty()) {
                return new ResponseEntity<>("Supplier id not found", HttpStatus.NOT_FOUND);
            }
            Optional<SupplierEntity> supplier = supplierRepository.findBySupplierUuid(supplierId);
            if (supplier.isPresent()) {
                return new ResponseEntity<>(modelMapper.map(supplier.get(), SupplierResponseDTO.class), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Supplier not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new CustomException("Failed to get Supplier");
        }
    }

    @Override
    public ResponseEntity<?> updateSupplier(SupplierRequestDTO supplierRequestDTO, String supplierId) {
        try {
            if (supplierRequestDTO == null && supplierId.isEmpty()) {
                return new ResponseEntity<>("Supplier ID or Details are missing", HttpStatus.BAD_REQUEST);
            }
            Optional<SupplierEntity> existingSupplier = supplierRepository.findBySupplierUuid(supplierId);
            if (existingSupplier.isPresent()) {
                SupplierEntity supplierEntity = modelMapper.map(supplierRequestDTO, SupplierEntity.class);
                supplierEntity.setSupplierId(existingSupplier.get().getSupplierId());
                supplierEntity.setSupplierUuid(existingSupplier.get().getSupplierUuid());

                SupplierEntity save = supplierRepository.save(supplierEntity);
                if (save != null) {
                    return new ResponseEntity<>("Supplier updated", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Supplier not updated", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>("Supplier not found", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            throw new CustomException("Failed to update supplier");
        }
    }
}
