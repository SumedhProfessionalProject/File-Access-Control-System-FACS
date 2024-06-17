package com.mca.mca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@RestController
public class LoginControl {
    
   

    @PostMapping("/loginattempt")
    public ModelAndView postMethodName(String username,
                                    @RequestParam("pass") String password,
                                    HttpServletRequest request) {
        
        if(username.equals("admin") && password.equals("admin")){
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            System.out.println(session.getId());
            return new ModelAndView("redirect:/home");
        }else{
            return new ModelAndView("login");
        }
    }
    

}
