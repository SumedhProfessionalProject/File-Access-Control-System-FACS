package com.example.demo.POJOS;

import org.apache.catalina.User;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * User POJO
 * @author
 *    sumedh
 */
@Entity(name="users")
@Data
public class UserPOJO {
    
    @Id
    private String username;

    private String name;

    private String position;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN,
        USER,
        READ
    }
    
}
