package com.cia.lms.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.service.AdminService;
 
@RestController
@RequestMapping("/admin")
public class AdminController {
 
    @Autowired
    AdminService service;

   
    @GetMapping("/print")
   public List<Users> fetchAdmin(){
        return service.fetchAdmin();
    }

 
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody Users user) {
        try {
            String message = service.registerAdmin(user);
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
             return ResponseEntity.status(500).body("An unexpected error occurred. Please try again.");
        }
    }

}
