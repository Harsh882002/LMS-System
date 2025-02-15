package com.cia.lms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.service.StudentService;

@RestController
@RequestMapping("/student")

public class StudentController {

    @Autowired
    StudentService service;
    

    @PostMapping("/register")
    ResponseEntity<?> studentRegister(@RequestBody Users user){
        try{
            String message  = service.studentRegister(user);
            return ResponseEntity.ok(message);
        }catch(Exception e){
            return ResponseEntity.status(500).body("Internal server Error : "  + e.getMessage());
        }


    }


}
