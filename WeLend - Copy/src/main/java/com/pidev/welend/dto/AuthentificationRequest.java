/*package com.pidev.welend.dto;

import com.pidev.welend.entities.Users;
import com.pidev.welend.entities.UsersType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
public class AuthentificationRequest extends Users {
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UsersType role;
Users user = new Users();
    public AuthentificationRequest (String email,String password,UsersType role){
        this.email=user.getEmail();
        this.password=user.getPwd();
        this.role=user.getRole();
    }
}*/
