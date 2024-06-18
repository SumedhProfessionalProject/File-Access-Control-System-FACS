package com.mca.mca.POJO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "users")
@Data
public class UserPojo {
    
    @Id
    private String username;

    private String name;

    private String position;

    private String password;

    private boolean isAdmin;

}
