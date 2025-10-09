package com.elira.pos.mapper;

import com.elira.pos.modal.Category;
import com.elira.pos.payload.dto.CategoryDTO;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .name(category.getName())
                .storeId(category.getStore().getId()!=null?category.getStore().getId():null)
                .build();
    }
}
