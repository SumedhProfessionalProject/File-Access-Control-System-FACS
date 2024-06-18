package com.mca.mca.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity(name="filemanager")
@Data
public class FilePOJO {
    
    @Id
    @Column(name="name")
    private String name;

    private String date;

    @Lob
    private byte[] file;

    private String creator;

}
