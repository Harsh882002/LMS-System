package com.cia.lms.system.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {
    
    @Autowired
   private UserService service;

    

    @PostMapping("/register")
    public ResponseEntity<?> registUsers(@RequestBody Users user){
        try{
            String message =  service.registUsers(user);
            return ResponseEntity.ok(message);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.status(500).body("Internal Server Error : " + e.getMessage());
        }

    }


}
