package com.cia.lms.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cia.lms.system.model.Users;
import com.cia.lms.system.repository.UserRepo;

@Service
public class TeacherService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public String teacherRegister(Users user) {

        try {
            user.setPassword(encoder.encode(user.getPassword()));
            repo.save(user);
            return "Teacher Added Sucessfully....";
        } catch (Exception e) {
            throw new RuntimeException("Unexpected Error Occured.. " + e.getMessage());
        }

    }

}
