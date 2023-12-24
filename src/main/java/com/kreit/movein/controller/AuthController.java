package com.kreit.movein.controller;

import com.kreit.movein.auth.JwtTokenService;
import com.kreit.movein.dto.AgentAuthenticationDto;
import com.kreit.movein.dto.AppUserDto;
import com.kreit.movein.dto.AuthenticationDto;
import com.kreit.movein.entity.Agent;
import com.kreit.movein.entity.AppUser;
import com.kreit.movein.repository.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AppUserRepository appUserRepository;
    private final AgentRepository agentRepository;


    @SneakyThrows
    @PostMapping("/app-user")
    public void signIn(@RequestBody @Valid AppUserDto appUserDto) {
        String password = appUserDto.password();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        String hashedPassword = hexString.toString();
        AppUser appUser = AppUser.builder()
                .email(appUserDto.email())
                .password(hashedPassword)
                .name(appUserDto.name())
                .phoneNumber(appUserDto.phoneNumber())
                .gender(appUserDto.gender())
                .build();
        appUserRepository.save(appUser);
    }

    @SneakyThrows
    @PostMapping("/login")
    public void login(
            HttpServletResponse response,
            @RequestBody AuthenticationDto authentication
    ) {
        String password = authentication.password();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        String hashedPassword = hexString.toString();
        AppUser appUser = appUserRepository.findByEmailIsAndPasswordIs(authentication.email(), hashedPassword).orElseThrow();

        int authTokenExpirationInMilliSeconds = 1000 * 60 * 60 * 24; // 1 day
        String token = JwtTokenService.createAppUserAuthenticationJwt(appUser.getId(), authTokenExpirationInMilliSeconds);

        String cookie = String.format("token=%s; Path=/app-user-api; Secure; HttpOnly; SameSite=None", token);
        response.addHeader("Set-Cookie", cookie);
    }

    @SneakyThrows
    @PostMapping("/login/agent")
    public void loginAgent(
            HttpServletResponse response,
            @RequestBody AgentAuthenticationDto authentication
    ) {
        String password = authentication.password();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        String hashedPassword = hexString.toString();
        Agent agent = agentRepository.findByLoginIdIsAndPasswordIs(authentication.loginId(), hashedPassword).orElseThrow();

        int authTokenExpirationInMilliSeconds = 1000 * 60 * 60 * 24; // 1 day

        String token = JwtTokenService.createAgentUserAuthenticationJwt(agent.getId(), authTokenExpirationInMilliSeconds);

        String cookie = String.format("token=%s; Path=/agent-api; Secure; HttpOnly; SameSite=None", token);
        response.addHeader("Set-Cookie", cookie);
    }
}
