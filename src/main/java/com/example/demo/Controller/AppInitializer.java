package com.example.demo.Controller;

import com.example.demo.POJOS.UserPOJO;
import com.example.demo.SERVICE.UserPOJOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer implements CommandLineRunner {

    @Autowired
    private UserPOJOService userService; // Service to handle user data

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Check if the admin user exists

        if (!userService.adminPresent()) {
            // Logic to show the setup page
            System.out.println("Setup required: please set the username and password");
            // Here you could redirect to a setup page or call a method to initialize the user
            UserPOJO userPOJO= UserPOJO.builder()
                    .roles("ROLE_ADMIN")
                    .email("xyz@gmail.com")
                    .admin_id(null)
                    .name("admin")
                    .password(passwordEncoder.encode("admin"))
                    .username("admin")
                    .build();
            userService.save(userPOJO);
        }
    }
}

