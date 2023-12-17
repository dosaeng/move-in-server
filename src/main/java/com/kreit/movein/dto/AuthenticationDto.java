package com.kreit.movein.dto;

import java.util.Objects;

public record AuthenticationDto(String email, String password) {
    public AuthenticationDto {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
    }
}
