package com.example.demo.REPOS;

import java.util.*;

import com.example.demo.POJOS.UserPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.POJOS.FilePOJO;

@Repository
public interface FileRepo extends JpaRepository<FilePOJO,String>{
    
//    List<FilePOJO> findByCreator(String creator);

    // @Query("SELECT c.creator FROM Creator c")
    // List<String> findAllCreator();
    @Query("SELECT f FROM FilePOJO f WHERE f.creator.id = :userId")
    List<FilePOJO> findAllByCreatorId(@Param("userId") String userId);

    @Query("SELECT f FROM FilePOJO f WHERE f.contentType LIKE 'image%'")
    List<FilePOJO> getImages();

    @Query("SELECT f FROM FilePOJO f WHERE f.creator=:id")
    List<FilePOJO> getData(@Param("id") String id);

    @Query("SELECT COUNT(*) FROM FilePOJO f WHERE f.creator.id=:id")
    Integer getInetgerData(@Param("id") String id);

    @Query("SELECT COUNT(*) FROM FilePOJO f WHERE f.creator.id=:id AND f.contentType LIKE 'image%'")
    Integer getNumberOfImages(@Param("id") String id);

    @Query("SELECT COUNT(*) FROM FilePOJO f WHERE f.creator.id=:id AND f.contentType='application/pdf'")
    Integer getNumberOfPDFS(@Param("id") String id);

    @Query("SELECT COUNT(*) FROM FilePOJO f WHERE f.creator.id=:id AND f.contentType LIKE 'video%'")
    Integer getNumberOfVideo(@Param("id") String id);


    @Query("SELECT u FROM UserPOJO u JOIN u.filePOJOS f WHERE f.id = :userId")
    UserPOJO getUser(@Param("user") String userId);

    @Query("SELECT f FROM FilePOJO f WHERE f.creator.id = :userId")
    List<FilePOJO> getFilesForUser(@Param("userId") String userId);

}
