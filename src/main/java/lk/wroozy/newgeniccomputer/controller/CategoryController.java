package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.dto.request.CategoryRequestDTO;
import lk.wroozy.newgeniccomputer.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequestDTO categoryRequestDTO, Principal principal) {
        LOGGER.info("request - category | addCategory | categoryRequestDTO: {} | AdminId: {}", categoryRequestDTO, principal.getName());
        ResponseEntity<?> response = categoryService.addCategory(categoryRequestDTO, principal.getName());
        LOGGER.info("response - category | addCategory | response: {}", response);
        return response;
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryRequestDTO categoryRequestDTO, @RequestParam long categoryId, Principal principal) {
        LOGGER.info("request - category | updateCategory | categoryRequestDTO: {} | categoryId: {} | AdminId: {}", categoryRequestDTO, categoryId, principal.getName());
        ResponseEntity<?> response = categoryService.updateCategory(categoryRequestDTO, categoryId);
        LOGGER.info("response - category | updateCategory | response: {}", response);
        return response;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable long categoryId, Principal principal) {
        LOGGER.info("request - category | getCategory | categoryId: {} | AdminId: {}", categoryId, principal.getName());
        ResponseEntity<?> response = categoryService.getCategory(categoryId);
        LOGGER.info("response - category | getCategory | response: {}", response);
        return response;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCategories(Principal principal) {
        LOGGER.info("request - category | getAllCategories | AdminId: {}", principal.getName());
        ResponseEntity<?> response = categoryService.getAllCategory();
        LOGGER.info("response - category | getAllCategories | response: {}", "Fetch all categories");
        return response;
    }

    @DeleteMapping("/deleteCategory")
    public ResponseEntity<?> deleteCategory(@RequestParam long categoryId, Principal principal) {
        LOGGER.info("request - category | getCategory | categoryId: {} | AdminId: {}", categoryId, principal.getName());
        ResponseEntity<?> response = categoryService.removeCategory(categoryId);
        LOGGER.info("response - category | getCategory | response: {}", response);
        return response;
    }
}
