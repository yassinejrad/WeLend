package com.pidev.welend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    private String role;
    private Boolean Locked;
    private Boolean Enable;

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "rafiaaons.zitouni@esprit.tn",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("admin"))
            ),
            new User(
                    "agent.mail@esprit.tn",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("Agent"))
            )
    );

    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS.stream().filter(u -> u.getUsername().equals(email)).findFirst().orElseThrow(() -> new UsernameNotFoundException("No User Found"));
    }




}
