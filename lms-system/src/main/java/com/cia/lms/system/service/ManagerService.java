package com.cia.lms.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.repository.UserRepo;

@Service
public class ManagerService {

    @Autowired 
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;
    
    public String managerRegister(Users user){
        try{
            user.setPassword(encoder.encode(user.getPassword()));
            repo.save(user);
            return "Manager Added Successfully....";
        }catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Duplicate entry: The email or username is already in use.");
        } catch (IllegalArgumentException e) {
            throw e;  // Propagate already handled exceptions
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred while registering the admin.");
        } 
    
    }
}
