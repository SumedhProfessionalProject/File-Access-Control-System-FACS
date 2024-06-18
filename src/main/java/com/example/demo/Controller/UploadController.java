package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.POJOS.FilePOJO;
import com.example.demo.SERVICE.FileService;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UploadController {
    
    @Autowired
    private FileService fileService;

     public String latestDate(){
       
                // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Format the date as a string
        String dateString = currentDate.format(formatter);
        
        // Print the formatted date string
        return dateString;
            
        
        
    }

    @PostMapping("/upload")
    public ModelAndView postMethodName(@RequestParam MultipartFile file,
                                    @RequestParam String name        
                                ,HttpSession session) throws IOException {

        

        FilePOJO filePOJO=new FilePOJO();
        filePOJO.setContentType(file.getContentType());
        filePOJO.setCreator((String)session.getAttribute("user"));
        filePOJO.setFilename(name);
        filePOJO.setDate(latestDate());
        filePOJO.setFile(file.getBytes());
        filePOJO.setName(file.getOriginalFilename());

        fileService.add(filePOJO);

        filePOJO=null;

        return new ModelAndView("redirect:/file");
        
    }
    


}
