package com.example.demo.Controller;

import com.example.demo.POJOS.UserPOJO;
import com.example.demo.SERVICE.UserPOJOService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProfileController {

    @Autowired
    private UserPOJOService userPOJOService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/profile")
    public ModelAndView modelAndView(HttpSession session){

        return new ModelAndView("profile").addObject("profile",userPOJOService.getUser(
                (String) session.getAttribute("id")
        ));

    }

    @PostMapping("/profile")
    public ModelAndView post(
            @RequestParam(value = "password") String password,
            HttpSession session
    ){
        UserPOJO userPOJO=userPOJOService.getUser((String) session.getAttribute("id"));


        userPOJO.setPassword(passwordEncoder.encode(password));

        userPOJOService.save(userPOJO);

        return new ModelAndView("redirect:/profile");

    }
}
