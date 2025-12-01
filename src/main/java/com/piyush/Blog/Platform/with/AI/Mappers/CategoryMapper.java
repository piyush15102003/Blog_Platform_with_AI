package com.piyush.Blog.Platform.with.AI.Mappers;

import com.piyush.Blog.Platform.with.AI.domains.PostStatus;
import com.piyush.Blog.Platform.with.AI.domains.dtos.CategoriesDto;
import com.piyush.Blog.Platform.with.AI.domains.entities.Category;
import com.piyush.Blog.Platform.with.AI.domains.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    @Mapping(target = "postCounts", source = "posts", qualifiedByName = "calculatePostCount")
    CategoriesDto toDto(Category category);

    default long calculatePostCount(List<Post> posts){
        if(posts == null){
            return 0;
        }
        return posts
                .stream().filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }


}
