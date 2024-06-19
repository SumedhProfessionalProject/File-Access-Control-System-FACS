package com.example.demo.Config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.POJOS.UserPOJO;


/**
 * This is for auth 
 * by default spring boot expects ROLE_<role>
 * @implNote UserDetails
 * authoritize
 */
public class CustomUserDetails implements UserDetails{

    private final UserPOJO userPOJO;

    public CustomUserDetails(UserPOJO user) {
        this.userPOJO = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = "ROLE_" + userPOJO.getRole().name();
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
       
        return userPOJO.getPassword();
    }
    
    @Override
    public String getUsername() {
        return userPOJO.getUsername();
        
    }

    public String getName(){
        return userPOJO.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
