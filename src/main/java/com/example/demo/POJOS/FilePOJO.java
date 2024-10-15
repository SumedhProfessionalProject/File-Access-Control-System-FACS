package com.example.demo.POJOS;

import jakarta.persistence.*;
import lombok.Data;

/**
 *  File POJO
 * @author
 *    sumedh
 */
@Entity
@Table(name="filemanager")
@Data
public class FilePOJO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String filename;

    private String date;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String file;

    private String creator;


    private String contentType;




}
