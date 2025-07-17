package com.bakerx.bakerz.Service;

import com.bakerx.bakerz.model.Category;
import com.bakerx.bakerz.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImple  implements CategoryService {


    //private List<Category> categories = new ArrayList<>();
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public void addCategory(Category category) {

        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found"));
        categoryRepository.delete(category);
        return "deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedcategory= categoryRepository.findById(categoryId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
                category.setCategoryId(categoryId);
                savedcategory = categoryRepository.save(category);
                return savedcategory;
    }
}
