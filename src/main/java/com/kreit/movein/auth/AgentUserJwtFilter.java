package com.kreit.movein.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.SecurityException;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

public class AgentUserJwtFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            boolean validated = false;
            HttpServletRequest httpRequest = (HttpServletRequest) request;

            if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
                chain.doFilter(request, response);
                return;
            }

            // 토큰
            Cookie[] cookies = httpRequest.getCookies();
            if (cookies == null) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }

            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();

                if (cookieName.equals("token")) {
                    String token = cookieValue;

                    Claims cliams = JwtTokenService.getAgentUserTokenClaims(token);
                    request.setAttribute("agentUserId", cliams.get("id"));
                    validated = true;
                    chain.doFilter(request, response);
                    break;
                }
            }
            if (!validated) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            }
        } catch (
                SecurityException e) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }
}
