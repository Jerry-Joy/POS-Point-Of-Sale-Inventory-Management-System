package com.elira.pos.payload.dto;

import com.elira.pos.domain.StoreStatus;
import com.elira.pos.modal.StoreContact;
import com.elira.pos.modal.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class StoreDTO {

    private Long id;

    private String brand;

    private UserDto storeAdmin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String description;

    private String storeType;

    private StoreStatus status;

    private StoreContact contact;
}
