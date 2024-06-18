package com.mca.mca.REPOS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mca.mca.POJO.FilePOJO;
import java.util.List;


@Repository
public interface FileRepo extends JpaRepository<FilePOJO,String>{
    
    List<FilePOJO> findByCreator(String creator);

}
