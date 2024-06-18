package com.example.demo;

import org.apache.catalina.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="users")
@Data
public class UserPOJO {
    
    @Id
    private String username;

    private String name;

    private String position;

    private String password;

    private boolean isadmin;

}
