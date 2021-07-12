package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.request.CategoryRequestDTO;
import lk.wroozy.newgeniccomputer.dto.response.CategoryResponseDTO;
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

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public ResponseEntity<?> updateCategory(CategoryRequestDTO categoryRequestDTO, long categoryId) {
        try{
            if (categoryRequestDTO == null && categoryId == 0){
                return new ResponseEntity<>("Category Id or category details not found",HttpStatus.BAD_REQUEST);
            }
            Optional<CategoryEntity> existingCategory = categoryRepository.findById(categoryId);
            if (existingCategory.isEmpty()){
                return new ResponseEntity<>("Category not found",HttpStatus.BAD_REQUEST);
            }
            CategoryEntity categoryEntity = modelMapper.map(categoryRequestDTO, CategoryEntity.class);
            categoryEntity.setCategoryId(existingCategory.get().getCategoryId());
            categoryEntity.setAdminEntity(existingCategory.get().getAdminEntity());

            CategoryEntity save = categoryRepository.save(categoryEntity);
            if (save == null)
                return new ResponseEntity<>("Category not update",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Category update",HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("Failed to update category : "+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getCategory(long categoryId) {
        try{
            if (categoryId == 0)
                return new ResponseEntity<>("Category Id not found",HttpStatus.BAD_REQUEST);

            Optional<CategoryEntity> categoryEntity = categoryRepository.findById(categoryId);
            if (categoryEntity.isEmpty())
                return new ResponseEntity<>("No category for id : "+categoryId,HttpStatus.BAD_REQUEST);

            CategoryResponseDTO responseDTO = modelMapper.map(categoryEntity.get(), CategoryResponseDTO.class);
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getAllCategory() {
        try{
            List<CategoryEntity> all = categoryRepository.findAll();
            if(all.isEmpty())
                return new ResponseEntity<>("No categories found",HttpStatus.NOT_FOUND);

            List<CategoryResponseDTO> categoryResponseList = new ArrayList<>();
            for (CategoryEntity categoryEntity :
                    all) {
                categoryResponseList.add(modelMapper.map(categoryEntity,CategoryResponseDTO.class));
            }

            return new ResponseEntity<>(categoryResponseList,HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("Failed to get all categories : "+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> removeCategory(long categoryId) {
        try {
            if (categoryId ==0)
                return new ResponseEntity<>("Category Id not found",HttpStatus.BAD_REQUEST);

            Optional<CategoryEntity> byId = categoryRepository.findById(categoryId);
            if (byId.isEmpty())
                return new ResponseEntity<>("Category not found",HttpStatus.NOT_FOUND);

            categoryRepository.delete(byId.get());
            return new ResponseEntity<>("Category remove",HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("Failed to remove category : "+e.getMessage());
        }
    }
}
