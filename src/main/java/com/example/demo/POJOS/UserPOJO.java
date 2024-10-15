package com.example.demo.POJOS;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.*;

/**
 * User POJO
 * @author
 *    sumedh
 */
@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NonNull
    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @NonNull
    @Column
    private String roles;

    @NonNull
    @Column
    private String name;

    @Column(unique = true)
    private String email;




}
