package com.example.demo.Controller;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.POJOS.FilePOJO;
import com.example.demo.SERVICE.FileService;

@RestController
public class Download {
    
    @Autowired
    private FileService fileService;

    @GetMapping(
        value = "/download"
    )
    public ResponseEntity<byte[]> files(@RequestParam String download) throws IOException {


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileService.getFile(download).getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + download + "\"")
                .body(fileService.getFile(download).getFile());
    }

    
}
