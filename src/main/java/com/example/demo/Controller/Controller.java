package com.example.demo.Controller;

import java.util.*;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.POJOS.FilePOJO;
import com.example.demo.POJOS.UserPOJO;
import com.example.demo.SERVICE.FileService;
import com.example.demo.SERVICE.UserPOJOService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@SessionAttributes("user")
@RestController
public class Controller {

        @Autowired
        private UserPOJOService userPOJOService;

        @Autowired
        private FileService fileService;

        @GetMapping("/gallery")
        public ModelAndView getImgs(HttpSession session){
                return new ModelAndView("gallery").addObject("imgs",fileService.getAll(
                        (String) session.getAttribute("id")
                ));
        }

        @GetMapping("/file")
        public ModelAndView modelAndView(HttpSession session) throws Exception {

                        return new ModelAndView("file").addObject("files", fileService.getAll((String) session.getAttribute("id")));



        }

        @GetMapping("/login")
        public ModelAndView getImgslogim(){
                return new ModelAndView("login");
        }

        @PostMapping("/file/del")
        public ModelAndView deleteTheFile(@RequestParam String id){
                System.out.println(id);
                fileService.del(id);
                return new ModelAndView("redirect:/file");
        }
        
}
