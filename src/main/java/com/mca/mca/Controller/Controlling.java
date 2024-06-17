package com.mca.mca.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Controlling {
    

    @GetMapping("/")
    public String home(){
        return "login";
    }

    @GetMapping("/home")
    public String land() {
        return "landing";
    }
    
}
