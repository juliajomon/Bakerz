package com.bakerx.bakerz.Service;

import com.bakerx.bakerz.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    void addCategory(Category category);

    String deleteCategory(Long icategoryId);

    Category updateCategory(Category category, Long categoryId);
}
