package com.example.demo.REPOS;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.POJOS.UserPOJO;

@Repository
public interface UserRepo extends JpaRepository<UserPOJO,String>{
    

}
