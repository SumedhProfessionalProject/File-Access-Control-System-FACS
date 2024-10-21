package com.example.demo.Error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CustomErrorController implements ErrorController {
    

    @GetMapping("/error")
    public ModelAndView getMethodName(HttpServletRequest request) {
        
        Integer status=Integer.valueOf(
                request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
                .toString()
            );
    
        if(status==HttpStatus.NOT_FOUND.value()){
            return new 
               ModelAndView("error").
               addObject("msg", "RESOURCE NOT FOUND");
        }else if (status == HttpStatus.FORBIDDEN.value()) {
            return new 
               ModelAndView("error").
               addObject("msg", "FORBIDDEN ACCESS");
        }else if(status == HttpStatus.INTERNAL_SERVER_ERROR.value()){
            System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return new
               ModelAndView("error").
               addObject("msg", HttpStatus.INTERNAL_SERVER_ERROR.toString());

        }else{
            return new 
               ModelAndView("error").
               addObject("msg", "AN ERROR OCCURRED");
        }
    }
    
}
