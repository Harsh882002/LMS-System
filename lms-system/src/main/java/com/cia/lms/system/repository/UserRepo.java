package com.cia.lms.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cia.lms.system.model.Role;
import com.cia.lms.system.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    
    Users findByEmail(String email);

    List<Users> findByRole(Role role);

}
 