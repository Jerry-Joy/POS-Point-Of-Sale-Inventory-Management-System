package com.elira.pos.payload.dto;

import com.elira.pos.modal.Store;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {

    private Long id;

    private String name;

    //private Store store;

    private Long storeId;
}
