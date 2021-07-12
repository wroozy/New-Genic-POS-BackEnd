package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.dto.request.CategoryRequestDTO;
import lk.wroozy.newgeniccomputer.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequestDTO categoryRequestDTO, Principal principal){
        LOGGER.info("request - category | addCategory | categoryRequestDTO: {} | AdminId: {}",categoryRequestDTO, principal.getName());
        ResponseEntity<?> response = categoryService.addCategory(categoryRequestDTO, principal.getName());
        LOGGER.info("response - category | addCategory | response: {}",response);
        return response;
    }
}
