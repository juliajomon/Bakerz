package com.bakerx.bakerz.Service;

import com.bakerx.bakerz.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImple  implements CategoryService {

    private long nextId = 1L;
    private List<Category> categories = new ArrayList<>();
    @Override
    public List<Category> getCategories() {
        return categories;
    }
    @Override
    public void addCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst().get();
        categories.remove(category);
        return "deleted";
    }
}
