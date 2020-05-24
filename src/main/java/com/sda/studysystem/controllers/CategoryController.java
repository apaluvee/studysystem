package com.sda.studysystem.controllers;

import com.sda.studysystem.models.Category;
import com.sda.studysystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for Category operations
 *
 * @author Alar
 */

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> showAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long categoryId, Category category) {
        category.setId(categoryId);
        categoryService.updateCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreCategory(@PathVariable("id") Long categoryId) {
        categoryService.restoreCategoryById(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


