package com.cia.lms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cia.lms.system.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {
    
    @Autowired
   private UserService service;

    @GetMapping("/get")
    public String getUser(){
        return service.temp();
    }

}
