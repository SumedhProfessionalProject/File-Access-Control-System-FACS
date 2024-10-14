package com.example.demo.SERVICE;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserPOJOService  {
  
    @Autowired
    private UserRepo userRepo;



    public void save(UserPOJO user){
        userRepo.save(user);
    }

    public boolean isUsernamePresent(String username){

        return userRepo.findByUsername(username).isEmpty();
    }

    
    /**
     * Returbs boolean if Role not admin
     * @param name
     * @return
     * 
     */
//    public boolean checkAdmin(String name,String password){
//        UserPOJO userPojo=userRepo.findById(name).orElse(null);
//       // return userPojo !=null && userPojo.getRole() == UserPOJO.Role.ADMIN && userPojo.getPassword().equals(userRepo.) ;
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        if(userPojo.getRole()==UserPOJO.Role.ADMIN){
//
//            if(
//                passwordEncoder.matches(password, userRepo.findById(name).get().getPassword())      )
//                   {
//
//                    System.out.println(userRepo.findById(name).get().getPassword() +"\n"+passwordEncoder.encode(password));
//                return true;
//            }
//        }
//        return false;
//
//    }

    public boolean isAdmin(String name){
        UserPOJO userPojo=userRepo.findById(name).orElse(null);
        return userPojo !=null && userPojo.getRoles().equals("ROLE_ADMIN") ;

    }

    
    public List<UserPOJO> getAll(){
        return userRepo.findAll();
    }

    public boolean adminPresent(){
        return userRepo.existsAdminUser();
    }

    public UserPOJO getUser(String id){
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Username not found"));
    }




}
