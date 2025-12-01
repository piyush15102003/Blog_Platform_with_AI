package com.piyush.Blog.Platform.with.AI.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriesDto {
    private UUID id;
    private String name;
    private Long postCount;
}
