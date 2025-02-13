package com.cia.lms.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.repository.UserRepo;

@Service
public class StudentService {
    
    @Autowired 
    UserRepo repo;

    public String studentRegister(Users user){

        try{
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
