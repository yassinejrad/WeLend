package com.pidev.welend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthentificationRequest {
    private String email;
    private String password;
}
