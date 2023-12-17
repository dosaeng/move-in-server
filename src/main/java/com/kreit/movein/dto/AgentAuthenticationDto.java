package com.kreit.movein.dto;

import java.util.Objects;

public record AgentAuthenticationDto(String loginId, String password) {
    public AgentAuthenticationDto {
        Objects.requireNonNull(loginId);
        Objects.requireNonNull(password);
    }
}
