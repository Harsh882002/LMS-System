package com.cia.lms.system.service;

 import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JWTService jwtService){
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String authenticateUser(String email, String password){
        Authentication authentication = authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(email, password));

             UserDetails userDetails = (UserDetails) authentication.getPrincipal();

return jwtService.generateToken(userDetails.getUsername());

        
    }
}
