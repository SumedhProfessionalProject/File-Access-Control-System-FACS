package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

        @Autowired
        private UserPOJOService userPOJOService;

        @PostMapping("/registerhtml")
        public ModelAndView processRegister(@RequestParam String username,
                                            @RequestParam String password,
                                            @RequestParam String name,
                                            @RequestParam String position,
                                            @RequestParam String adminusername,
                                            @RequestParam String adminpassword
                                    ) {
            ModelAndView modelAndView=new ModelAndView("register");
            
            if(userPOJOService.checkAdmin(adminusername, adminpassword)){  
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                UserPOJO userPOJO=new UserPOJO();
                userPOJO.setIsadmin(false);
                userPOJO.setName(name);
                userPOJO.setPosition(position);
                userPOJO.setUsername(username);
                String encodedPassword = passwordEncoder.encode(password);
                userPOJO.setPassword(encodedPassword);
            
                userPOJOService.save(userPOJO);
                passwordEncoder=null;
                userPOJO=null;
                modelAndView.addObject("msg", "success");
                return modelAndView;
            }
            modelAndView.addObject("msg", "unsuccess");
            return modelAndView;
            
            
        }
}
