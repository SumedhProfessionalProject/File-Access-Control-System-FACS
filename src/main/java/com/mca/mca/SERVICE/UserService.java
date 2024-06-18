package com.mca.mca.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.mca.mca.POJO.UserPojo;
import com.mca.mca.REPOS.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public UserPojo getUser(String username){
        UserPojo userPojo=userRepo.findById(username).orElse(null);
        return userPojo;
    }

    
    
}
