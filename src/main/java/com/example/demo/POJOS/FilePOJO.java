package com.example.demo.POJOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *  File POJO
 * @author
 *    sumedh
 */
@Getter
@Setter
@Entity
@Table(name = "filemanager")
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


    private String contentType;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private UserPOJO creator;

}
