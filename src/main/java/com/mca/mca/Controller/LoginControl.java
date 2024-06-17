package com.mca.mca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.serv

@Controller
public class LoginControl {
    
    @Autowired
    private HttpSession

    @PostMapping("/loginattempt")
    public String postMethodName(@RequestParam String username,
                                    @RequestParam String password) {
        //TODO: process POST request
        htt
        return entity;
    }
    

}
