package com.mca.mca.SERVICE;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mca.mca.POJO.FilePOJO;
import com.mca.mca.REPOS.FileRepo;

@Service
public class FileService {
    
    @Autowired
    private FileRepo fileRepo;
    
    
    public void add(FilePOJO file){
        
        fileRepo.save(file);
        
    }

    public List<FilePOJO> getAll(String user){

        List<FilePOJO> list=fileRepo.findByCreator(user);
        return list;


    }

    public List<FilePOJO> getAllAsAdmin(){
        return fileRepo.findAll();
    }

}
