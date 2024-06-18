package com.example.demo.SERVICE;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Config.CustomUserDetails;
import com.example.demo.POJOS.UserPOJO;
import com.example.demo.REPOS.UserRepo;

@Service
public class UserPOJOService implements UserDetailsService {
    
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPOJO user = userRepo.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public void save(UserPOJO user){
        userRepo.save(user);
    }

    public boolean checkAdmin(String user,String password){
        
        List<UserPOJO> list=userRepo.findByisadminTrue();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
        for (UserPOJO userPOJO : list) {
            if(userPOJO.getUsername().equals(user)){
                if(encoder.matches(password, userPOJO.getPassword())){
                    return true;
                }
                return false;
            }
        }
        return false;

    }

}
