package com.bakerx.bakerz.Controller;

import com.bakerx.bakerz.Service.CategoryService;
import com.bakerx.bakerz.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;


    @GetMapping("/api/public/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/api/public/categories")
    public String addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return "success";
    }

    @DeleteMapping("/api/public/categories/{categoryId}")
    public String DeleteCategory(@PathVariable Long categoryId) {
         String status = categoryService.deleteCategory(categoryId);
         return status;

    }
}

