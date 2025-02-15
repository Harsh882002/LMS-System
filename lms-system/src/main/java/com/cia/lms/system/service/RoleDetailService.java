package com.cia.lms.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cia.lms.system.model.UserPrinciple;
import com.cia.lms.system.model.Users;
import com.cia.lms.system.repository.UserRepo;

@Service
public class RoleDetailService implements UserDetailsService {

    @Autowired 
   private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Users user = repo.findByEmail(email);

    if(user == null){
        System.out.println("User Not Found" + email);
        throw new UsernameNotFoundException("User Not Found");
    }
 
    System.out.println("Encypted password: " + user.getPassword());

    return new UserPrinciple(user);
    }
}
