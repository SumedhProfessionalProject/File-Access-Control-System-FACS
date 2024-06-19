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

@Service
public class UserPOJOService implements UserDetailsService {
    
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPOJO user = userRepo.findById(username).orElse(null);
        CustomUserDetails customUserDetails=new CustomUserDetails(user);
        
        System.out.println("hydsahfgbhsjdfjsdgbhf");
        if (user == null ) {
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("hydsahfgbhsjdfjsdgbhf");
        // UserBuilder builder=User.withUserDetails(new CustomUserDetails(user));
        if(user.getRole()==UserPOJO.Role.ADMIN){
            // List<SimpleGrantedAuthority> authorities = Arrays.asList(
            //     new SimpleGrantedAuthority("READ"),
            //     new SimpleGrantedAuthority("CREATE"),
            //     new SimpleGrantedAuthority("DELETE")
            // );
            //builder.authorities(new CustomUserDetails(user).getAuthorities());
            return customUserDetails;


        }else{
            // List<SimpleGrantedAuthority> authorities = Arrays.asList(
            //     new SimpleGrantedAuthority("READ"),
            //     new SimpleGrantedAuthority("CREATE")
            // );
            //builder.authorities(new CustomUserDetails(user).getAuthorities());
            return customUserDetails;
        }
        
        // builder.roles(user.getRole().toString());
        // return builder.build();
    }
    
    public void save(UserPOJO user){
        userRepo.save(user);
    }

    // public boolean checkAdmin(String user,String password){
        
    //     List<UserPOJO> list=userRepo.fin
    //     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
    //     for (UserPOJO userPOJO : list) {
    //         if(userPOJO.getUsername().equals(user)){
    //             if(encoder.matches(password, userPOJO.getPassword())){
    //                 return true;
    //             }
    //             return false;
    //         }
    //     }
    //     return false;

    // }

    public boolean isAdmin(String name){
        UserPOJO userPojo=userRepo.findById(name).orElse(null);
        return userPojo !=null && userPojo.getRole() == UserPOJO.Role.ADMIN;
        
    }

    public List<UserPOJO> getAll(){
        return userRepo.findAll();
    }

}
