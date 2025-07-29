package com.bakerx.bakerz.Controller;

import com.bakerx.bakerz.Service.CategoryService;
import com.bakerx.bakerz.model.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;


    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> category = categoryService.getCategories();
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> addCategory(@Valid @RequestBody Category category) {

            categoryService.addCategory(category);
            return new ResponseEntity<>("added category", HttpStatus.CREATED);

    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> DeleteCategory(@PathVariable Long categoryId) {

            String status = categoryService.deleteCategory(categoryId);
            return ResponseEntity.ok(status);


    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid@RequestBody Category category ,@PathVariable Long categoryId) {

            Category saved = categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("updated " + categoryId, HttpStatus.OK);

    }
}

