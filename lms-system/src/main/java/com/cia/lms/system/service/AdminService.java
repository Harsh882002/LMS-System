package com.cia.lms.system.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.repository.UserRepo;

@Service
public class AdminService {
    
    @Autowired
    UserRepo repo;
    
public String registerAdmin(Users user){
    try{
        repo.save(user);
        return "User Added Successfully..";
    }catch(DataIntegrityViolationException e){
            throw new IllegalArgumentException("Duplicate entry or consraint violation " + e.getMessage());
    }catch(Exception e){
        throw new RuntimeException("Unexpected  error Occured: " + e.getMessage());
    }
}

    
}
