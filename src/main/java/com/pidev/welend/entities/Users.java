package com.pidev.welend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Repository
@Getter
@Setter
@Entity
@Table( name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer UserID;
    private String email;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private UsersType role;
    private Boolean Locked;
    private Boolean Enable;






}
