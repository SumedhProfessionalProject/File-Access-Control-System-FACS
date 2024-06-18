package com.mca.mca.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mca.mca.POJO.FilePOJO;
import com.mca.mca.SERVICE.FileService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView getMethodName(@RequestParam MultipartFile file,HttpServletRequest request) throws Exception{
        
        if(request.getSession()==null)
            return new ModelAndView("redirect:/login");

        FilePOJO filePOJO=new FilePOJO();
        filePOJO.setCreator((String)request.getSession().getAttribute("user"));
        filePOJO.setFile(file.getBytes());
        filePOJO.setDate(latestDate());
        filePOJO.setName(file.getOriginalFilename());

        fileService.add(filePOJO);

        filePOJO=null;

        System.out.println(fileService.getAll((String)request.getSession().getAttribute("user")));
    
        return new ModelAndView("redirect:/home");
    }
    
       
    
}



