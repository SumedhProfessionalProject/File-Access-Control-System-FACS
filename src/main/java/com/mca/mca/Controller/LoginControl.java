package com.mca.mca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.*;

@Controller
public class LoginControl {
    
    @Autowired
    private HttpSession HttpSession;

    @PostMapping("/loginattempt")
    public String postMethodName(@RequestParam String username,
                                    @RequestParam String password) {
        //TODO: process POST request
        
        if(username=="admin" && password=="admin"){
            HttpSession.setAttribute("user", username);
            System.out.println(HttpSession.getAttribute(username));
            return "landing";
        }else{
            return "login";
        }
    }
    

}
