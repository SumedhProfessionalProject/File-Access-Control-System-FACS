package com.example.demo.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.demo.POJOS.FilePOJO;
import com.example.demo.POJOS.UserPOJO;
import com.example.demo.REPOS.FileRepo;
import com.example.demo.REPOS.UserRepo;

@Service
public class FileService {
    
    @Autowired
    private FileRepo fileRepo;
    
    @Autowired
    private UserRepo userRepo;
    
    public void add(FilePOJO file){
        
        fileRepo.save(file);
        
    }

    public List<FilePOJO> getAll(String user){

       if(userRepo.findById(user).orElse(null).isIsadmin()){
            return fileRepo.findAll();
       }
       return fileRepo.findByCreator(user);
    }

    

    // public List<String> getCreatorName(){
    //     return fileRepo.findAllCreator();
    // }
    // public List<FilePOJO> getAllAsAdmin(){
    //     return fileRepo.findAll();
    // }


}
