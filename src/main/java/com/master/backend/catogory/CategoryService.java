package com.master.backend.catogory;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category createCategory(Category category);
}
