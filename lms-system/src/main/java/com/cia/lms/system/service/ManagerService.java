package com.cia.lms.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.repository.UserRepo;

@Service
public class ManagerService {

    @Autowired 
    UserRepo repo;
    
    public String managerRegister(Users user){
        try{
            repo.save(user);
            return "Manager Added Successfully....";
        }catch(Exception e){
    
            throw new RuntimeException("Unexpected Error : " + e.getMessage());

        }
    
    }
}
