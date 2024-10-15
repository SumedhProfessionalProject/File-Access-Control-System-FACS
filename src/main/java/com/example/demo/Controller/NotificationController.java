package com.example.demo.Controller;

import com.example.demo.SERVICE.FileService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class NotificationController {

    @Autowired
    private FileService service;

    @GetMapping("/data")
    public ModelAndView modelAndView(HttpSession session){
        return new ModelAndView("data").addObject("hash",service.getInfo((String) session.getAttribute("id")));
    }


}
