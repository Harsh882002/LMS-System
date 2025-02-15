package com.cia.lms.system.controller;

import java.nio.file.attribute.UserPrincipal;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.Cookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cia.lms.system.model.LoginRequest;
import com.cia.lms.system.model.UserPrinciple;
import com.cia.lms.system.service.AuthService;
import com.cia.lms.system.service.JWTService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {

        try {
             
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails.getUsername());


                // Create a secure HTTP-only cookie for the JWT token
   Cookie cookie = new Cookie("jwt",token);
   cookie.setHttpOnly(true);
   cookie.setSecure(false);
   cookie.setPath("/");
   cookie.setMaxAge((int) TimeUnit.HOURS.toSeconds(1)); // Expires in 1 hour

   response.addCookie(cookie);


   return ResponseEntity.ok(Map.of("message", "Login successful! Token is stored in cookies"));
} catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid email or password"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Login failed", "details", e.getMessage()));
        }
    }

}
