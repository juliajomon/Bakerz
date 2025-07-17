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
        try {
            categoryService.addCategory(category);
            return new ResponseEntity<>("added", HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace(); // ✅ Will help you see the real cause in logs
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> DeleteCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
            return ResponseEntity.ok(status);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category ,@PathVariable Long categoryId) {
        try {
            Category saved = categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("updated " + categoryId, HttpStatus.OK);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}

