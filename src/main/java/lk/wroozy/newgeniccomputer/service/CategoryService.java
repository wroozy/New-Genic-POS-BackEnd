package lk.wroozy.newgeniccomputer.service;

import lk.wroozy.newgeniccomputer.dto.request.CategoryRequestDTO;
import lk.wroozy.newgeniccomputer.entity.CategoryEntity;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<?> addCategory(CategoryRequestDTO categoryRequestDTO,String adminId);

    ResponseEntity<?> updateCategory(CategoryRequestDTO categoryRequestDTO,long categoryId);

    ResponseEntity<?> getCategory(long categoryId);

    ResponseEntity<?> getAllCategory();

    ResponseEntity<?> removeCategory(long categoryId);

}

