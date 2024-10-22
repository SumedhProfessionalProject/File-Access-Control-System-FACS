package com.example.demo.SERVICE;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

import com.example.demo.POJOS.FilePOJO;
import com.example.demo.POJOS.UserPOJO;
import com.example.demo.REPOS.FileRepo;
import com.example.demo.REPOS.UserRepo;
import org.springframework.transaction.annotation.Transactional;

/**
 * File service to process files
 */
@Transactional
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


        if(userRepo.isAdmin(id)){
        //    System.out.println(fileRepo.findAll());
            return fileRepo.findAll();
        }else{
         //   System.out.println(fileRepo.getData(id));
            return fileRepo.getFilesForUser(id);
        }


    }

    public FilePOJO getFile(String name){
        return fileRepo.findById(name).orElseThrow(()->new RuntimeException("No file"));
    }

    public List<FilePOJO> getGallery(){
        return fileRepo.getImages();
    }

    public void del(String id){
        fileRepo.deleteById(id);
    }

    public HashMap<String,Integer> getInfo(String id){
        HashMap<String,Integer> hashMap=new HashMap<>();
        Integer img=fileRepo.getNumberOfImages(id);
        Integer pdf=fileRepo.getNumberOfPDFS(id);
        Integer video=fileRepo.getNumberOfVideo(id);
        Integer sum=img+pdf+video;

        Integer others=fileRepo.getInetgerData(id);
        others=others > sum ? others-sum : 0;

        hashMap.put("image",img);
        hashMap.put("pdf",fileRepo.getNumberOfPDFS(id));
        hashMap.put("video",fileRepo.getNumberOfVideo(id));
        hashMap.put("other",others);
        return hashMap;
    }

    public UserPOJO createUser(String id){
        return fileRepo.getUser(id);
    }



    
}
