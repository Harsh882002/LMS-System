package com.cia.lms.system.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrinciple implements UserDetails {

    private final Users user;

    //constructor
    public UserPrinciple(Users user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){

        if (user.getRole() == null) {
            System.out.println("Role is null for user: " + user.getEmail());
            return List.of();
        }
    
        System.out.println("Role: " + user.getRole().name());

        return List.of(new SimpleGrantedAuthority(user.getRole().name()));
     }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername(){
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override 
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    
}
