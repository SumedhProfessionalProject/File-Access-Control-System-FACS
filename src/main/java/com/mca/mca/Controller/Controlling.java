package com.mca.mca.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class Controlling {
    

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("login");
    }

    @GetMapping("/home")
    public String land() {
        return "landing";
    }
    
}
