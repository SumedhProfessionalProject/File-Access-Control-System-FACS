package com.example.demo.Controller;

import com.example.demo.POJOS.UserPOJO;
import com.example.demo.SERVICE.UserPOJOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
public class AdminController {

    @Autowired
    private UserPOJOService userPOJOService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/admin")
    public ModelAndView getApp(){
        return new ModelAndView("secured").addObject("users",userPOJOService.getAll());
    }

    @GetMapping("/admin/add")
    public ModelAndView getAdd(){
        return new ModelAndView("add");
    }

    @PostMapping("/admin/add")
    public ModelAndView getAdd(@RequestParam String name,@RequestParam String username,@RequestParam String password,
                               @RequestParam String email){

        ModelAndView modelAndView=new ModelAndView("add");
        if(userPOJOService.isUsernamePresent(username)){
            UserPOJO userPOJO=UserPOJO.builder()
                    .name(name)
                    .username(username)
                    .email(email)
                    .password(passwordEncoder.encode(password))
                    .roles("ROLE_USER")
                    .build();

            userPOJOService.save(userPOJO);
            userPOJO=null;
            modelAndView.addObject("msg","success");
        }else{
            modelAndView.addObject("msg","username exists");
        }
        return modelAndView;
    }
}
