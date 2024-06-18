package com.example.demo.Config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.POJOS.UserPOJO;

public class CustomUserDetails implements UserDetails{

    private UserPOJO userPOJO;

    public CustomUserDetails(UserPOJO user) {
        this.userPOJO = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }

    @Override
    public String getPassword() {
       
        return userPOJO.getPassword();
    }
    @Override
    public String getUsername() {
        return userPOJO.getUsername();
        
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
