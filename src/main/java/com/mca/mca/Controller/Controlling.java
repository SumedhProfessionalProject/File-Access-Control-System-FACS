package com.mca.mca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RestController
public class Controlling {
    

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("login");
    }

    @GetMapping("/home")
    public ModelAndView land(HttpSession session) {
        if(session!=null){
            ModelAndView modelAndView=new ModelAndView("landing");
            String name=(String)session.getAttribute("user");
            modelAndView.addObject("user", name);
            
            return modelAndView;
        }else{
            return new ModelAndView("login");
        }
    }

    @GetMapping("/logout")
    public ModelAndView getMethodName(HttpSession httpSession) {
        httpSession.invalidate();
        return new ModelAndView("login");
    }
    
    
}
