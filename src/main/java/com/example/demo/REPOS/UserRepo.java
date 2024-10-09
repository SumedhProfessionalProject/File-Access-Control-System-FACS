package com.example.demo.REPOS;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.POJOS.UserPOJO;

@Repository
public interface UserRepo extends JpaRepository<UserPOJO,String>{

    @Override
    Optional<UserPOJO> findById(String s);

    Optional<UserPOJO> findByUsername(String username);

    @Query("SELECT u FROM UserPOJO u WHERE u.admin_id = :adminId")
    List<UserPOJO> findUsernamesByAdminId(@Param("adminId") String adminId);

    @Query("SELECT COUNT(u) > 0 FROM UserPOJO u WHERE u.roles = 'ROLE_ADMIN'")
    boolean existsAdminUser();


}
