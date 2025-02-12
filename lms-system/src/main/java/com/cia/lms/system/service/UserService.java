package com.cia.lms.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public String temp(){
        return "Working well";
    }
    

    @Transactional
    public String registUsers(Users user){
        try{
             repo.save(user);
             return "User registered successfully ";
        }catch(DataIntegrityViolationException e){
            throw new IllegalArgumentException("Duplicate entry or consraint violation " + e.getMessage());
        }catch(Exception e){
            throw new RuntimeException("Unexpected  error Occured: " + e.getMessage());
        }
    }

}
