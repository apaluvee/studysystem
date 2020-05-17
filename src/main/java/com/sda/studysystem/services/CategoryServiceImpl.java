package com.sda.studysystem.services;

import com.sda.studysystem.models.Category;
import com.sda.studysystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean createCategory(Category category) {
        if (category == null) {
            return false;
        }
        category.setId(category.getId());
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean updateCategory(Category category) {
        if (category == null) {
            return false;
        }
        categoryRepository.saveAndFlush(category);
        return true;
    }

    @Override
    public Category getById(Long categoryId) {
        return categoryRepository.getOne(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean deleteCategoryById(Long categoryId) {
        Category category = getById(categoryId);
        if (categoryId == null) {
            return false;
        }
        category.setActive(false);
        updateCategory(category);
        return false;
    }

    private String getNewCategoryId() {
        double categoryId = Math.random();
        return "" + categoryId;
    }

    @Override
    public boolean restoreCategoryById(Long categoryId) {
        Category category = getById(categoryId);
        if (categoryId == null) {
            return false;
        }
        category.setActive(true);
        return updateCategory(category);
    }

}
