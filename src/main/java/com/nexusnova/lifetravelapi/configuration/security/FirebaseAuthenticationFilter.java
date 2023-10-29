package com.nexusnova.lifetravelapi.configuration.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FirebaseAuthenticationFilter extends OncePerRequestFilter {

    private static final String[] AUTH_WHITELIST_PUBLIC = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources",
            "/swagger-ui.html",
            "/webjars",
            "/v3/api-docs",
            "/swagger-ui",
            "/demo",
            "/error",
            "/swagger-ui.html",
    };

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Check if the request is whitelisted
        boolean isWhitelisted = Arrays.stream(AUTH_WHITELIST_PUBLIC)
                .anyMatch(path -> request.getServletPath().startsWith(path));

        // If the request is whitelisted, skip the filter
        if (isWhitelisted) {
            chain.doFilter(request, response);
            return;
        }

        // Get the Firebase ID token from the request header
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        if (token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            // Create a JSON response indicating the error
            String errorResponse = "{\"error\": \"Unauthorized - Token is null\"}";
            try (PrintWriter out = response.getWriter()) {
                out.print(errorResponse);
            } catch (IOException e) {
                e.printStackTrace(); // Handle the IOException as needed
            }
        } else {
            try {
                FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(token);
                System.out.println(firebaseToken.getEmail());
            } catch (Throwable e) {
                logger.error("Error verifying Firebase token: " + e.getMessage(), e);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                // Create a JSON response indicating the error
                String errorResponse = "{\"error\": \"Unauthorized - Error verifying Firebase token\"}";
                try (PrintWriter out = response.getWriter()) {
                    out.print(errorResponse);
                } catch (IOException ex) {
                    ex.printStackTrace(); // Handle the IOException as needed
                }
            }
        }

        // Continue the filter chain
        chain.doFilter(request, response);
    }
}