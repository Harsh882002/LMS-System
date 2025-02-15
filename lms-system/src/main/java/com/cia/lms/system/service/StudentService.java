package com.cia.lms.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.repository.UserRepo;

@Service
public class StudentService {
    
    @Autowired 
   private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;
    

    public String studentRegister(Users user){

        try{
            user.setPassword(encoder.encode(user.getPassword()));
            repo.save(user);
            return "Student Added Sucessfully..";
        }catch(DataIntegrityViolationException e){
            throw new IllegalArgumentException("Duplicate Entry ot Data Voilation " + e.getMessage());
        }
        catch(Exception e){
            throw new RuntimeException("UnExpected Error Occured " + e.getMessage());
        }

    }


}
