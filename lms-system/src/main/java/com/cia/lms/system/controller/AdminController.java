package com.cia.lms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.service.AdminService;
 
@RestController
@RequestMapping("/user")
public class AdminController {

    @Autowired
    AdminService service;

    @PostMapping("/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody Users user) {
        try {
            String message = service.registerAdmin(user);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error : " + e.getMessage());
        }  
    }

}
