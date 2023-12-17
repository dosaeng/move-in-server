package com.kreit.movein.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public record AppUserDto(
        @Email
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotBlank
        String name,
        @NotBlank
        String phoneNumber,
        @NotBlank
        String gender
) {
}
