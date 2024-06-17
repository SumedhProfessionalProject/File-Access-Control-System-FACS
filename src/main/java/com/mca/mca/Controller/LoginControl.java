package com.mca.mca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;



@RestController
public class LoginControl {
    
    @Autowired
    private HttpSession httpSession;

    @PostMapping("/loginattempt")
    public ModelAndView postMethodName(String username,
                                    @RequestParam("pass") String password) {
        
        System.out.println("fdjhsgdfhjgsjdf");
        if(username.equals("admin") && password.equals("admin")){
            httpSession.setAttribute("user", username);
            System.out.println("hsfdfhsagdfh");
            System.out.println(httpSession.getAttribute("user"));
            return new ModelAndView("landing");
        }else{
            return new ModelAndView("login");
        }
    }
    

}
