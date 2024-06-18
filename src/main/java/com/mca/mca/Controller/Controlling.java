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
    

    @GetMapping("/login")
    public ModelAndView home(){
        return new ModelAndView("login");
    }

    @GetMapping("/home")
    public ModelAndView land(HttpServletRequest request) {
        if(request.getSession()!=null){
            ModelAndView modelAndView=new ModelAndView("landing");
            String name=(String)request.getSession().getAttribute("user");
            modelAndView.addObject("user", name);
            
            return modelAndView;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping("/logout")
    public ModelAndView getMethodName(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            session.invalidate();
        }
        return new ModelAndView("redirect:/login");
    }
    
    
}
