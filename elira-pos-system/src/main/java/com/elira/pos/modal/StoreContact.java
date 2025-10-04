package com.elira.pos.modal;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Embeddable
public class StoreContact {
    private String address;
    private String phone;

        @Email(message = "Invalid email format")
    private String email;
}
