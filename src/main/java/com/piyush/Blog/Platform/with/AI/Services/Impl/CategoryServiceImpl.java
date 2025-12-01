package com.piyush.Blog.Platform.with.AI.Services.Impl;

import com.piyush.Blog.Platform.with.AI.Repositories.CategoryRepository;
import com.piyush.Blog.Platform.with.AI.Services.CategoryService;
import com.piyush.Blog.Platform.with.AI.domains.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> listCategories(){
        return categoryRepository.findAllByPosts();
    }



}
