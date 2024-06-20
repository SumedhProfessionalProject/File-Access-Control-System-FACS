package com.example.demo.SERVICE;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Config.CustomUserDetails;
import com.example.demo.POJOS.UserPOJO;
import com.example.demo.REPOS.UserRepo;

/**
 * Handles service of user 
 * 
 * CustomUserDetails -> Service -> WebConfig
 * 
 * save(), isAdmin() , getAll()
 * @implNote UserDetailsService
 * 
 * loadUserByUsername()
 * 
 * @author sumedh
 * 
 */

@Service
public class UserPOJOService implements UserDetailsService {
  
    @Autowired
    private UserRepo userRepo;

    /**
     * loads username directly used by auth spring
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPOJO user = userRepo.findById(username).orElse(null);
        CustomUserDetails customUserDetails=new CustomUserDetails(user);
        
        System.out.println("hydsahfgbhsjdfjsdgbhf");
        if (user == null ) {
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("hydsahfgbhsjdfjsdgbhf");
        if(user.getRole()==UserPOJO.Role.ADMIN){
            
            return customUserDetails;


        }else{
            return customUserDetails;
        }
        
        
    }
    
    public void save(UserPOJO user){
        userRepo.save(user);
    }



    
    /**
     * Returbs boolean if Role not admin
     * @param name
     * @return
     * 
     */
    public boolean checkAdmin(String name,String password){
        UserPOJO userPojo=userRepo.findById(name).orElse(null);
       // return userPojo !=null && userPojo.getRole() == UserPOJO.Role.ADMIN && userPojo.getPassword().equals(userRepo.) ;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(userPojo.getRole()==UserPOJO.Role.ADMIN){
            if(
                passwordEncoder.encode(password).equals(   userRepo.findById(name).get().getPassword()    )     
                   ){
                return true;
            }
        }     
        return false;
   
    }

    public boolean isAdmin(String name){
        UserPOJO userPojo=userRepo.findById(name).orElse(null);
        return userPojo !=null && userPojo.getRole() == UserPOJO.Role.ADMIN  ;

    }

    
    public List<UserPOJO> getAll(){
        return userRepo.findAll();
    }

}
