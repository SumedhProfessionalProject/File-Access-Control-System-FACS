package com.mca.mca.REPOS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mca.mca.POJO.UserPojo;

@Repository
public interface UserRepo extends JpaRepository<UserPojo,String>{
    
}
