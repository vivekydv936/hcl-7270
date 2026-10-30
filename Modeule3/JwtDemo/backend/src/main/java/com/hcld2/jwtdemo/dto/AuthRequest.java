package com.hcld2.jwtdemo.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthRequest (@NotBlank String username,@NotBlank String Password) {

    public Object password() {
        return Password;
    }
}

