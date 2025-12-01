package com.piyush.Blog.Platform.with.AI.Controllers;

import com.piyush.Blog.Platform.with.AI.Mappers.CategoryMapper;
import com.piyush.Blog.Platform.with.AI.Services.Impl.CategoryServiceImpl;
import com.piyush.Blog.Platform.with.AI.domains.dtos.CategoriesDto;
import com.piyush.Blog.Platform.with.AI.domains.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    private final CategoryMapper categoryMapper;

    @GetMapping()
    public ResponseEntity<?>listCategories(){
        List<CategoriesDto> categories = categoryService.listCategories()
                .stream().map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(categories);
    }
}
