package com.example.demo.util;

import com.example.demo.POJOS.UserPOJO;
import com.example.demo.REPOS.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPOJO user = userRepo.findByUsername(username).orElse(null);
        // System.out.println("==================="+user);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new UserDetailModel(user);
    }


}
