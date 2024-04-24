package com.master.backend.api.catogory;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category createCategory(Category category);
}
