package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.request.CategoryRequestDTO;
import lk.wroozy.newgeniccomputer.entity.AdminEntity;
import lk.wroozy.newgeniccomputer.entity.CategoryEntity;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.repository.AdminRepository;
import lk.wroozy.newgeniccomputer.repository.CategoryRepository;
import lk.wroozy.newgeniccomputer.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private AdminRepository adminRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(AdminRepository adminRepository,
                               CategoryRepository categoryRepository,
                               ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> addCategory(CategoryRequestDTO categoryRequestDTO, String adminId) {
        try{
            if (categoryRequestDTO == null){
                return new ResponseEntity<>("Category details not found", HttpStatus.BAD_REQUEST);
            }
            Optional<AdminEntity> admin = adminRepository.findByUuid(adminId);
            if (!admin.isPresent()){
                return new ResponseEntity<>("Authorization failed",HttpStatus.UNAUTHORIZED);
            }
            if (categoryRepository.findByCategory(categoryRequestDTO.getCategory()).isPresent()){
                return new ResponseEntity<>("Category already added to system",HttpStatus.CONFLICT);
            }
            CategoryEntity categoryEntity = modelMapper.map(categoryRequestDTO, CategoryEntity.class);
            categoryEntity.setAdminEntity(admin.get());

            CategoryEntity entity = categoryRepository.save(categoryEntity);
            if (entity != null){
                return new ResponseEntity<>("Category add to system",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Category not add to system",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            throw new CustomException("Failed to create category");
        }
    }
}
