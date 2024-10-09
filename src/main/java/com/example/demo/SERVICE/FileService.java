package com.example.demo.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

import com.example.demo.POJOS.FilePOJO;
import com.example.demo.POJOS.UserPOJO;
import com.example.demo.REPOS.FileRepo;
import com.example.demo.REPOS.UserRepo;

/**
 * File service to process files
 */
@Service
public class FileService {
    
    @Autowired
    private FileRepo fileRepo;
    
    @Autowired
    private UserRepo userRepo;
    

    public void add(FilePOJO file){
        
        fileRepo.save(file);
        
    }

    /**
     * get all info for both admin and user
     * @param user
     * @return List<FilePOJO>
     */
    public List<FilePOJO> getAll(String id){


       return fileRepo.getData(id);
    }

    public FilePOJO getFile(String name){
        return fileRepo.findById(name).orElse(null);
    }

    public List<FilePOJO> getGallery(){
        return fileRepo.getImages();
    }


    
}
