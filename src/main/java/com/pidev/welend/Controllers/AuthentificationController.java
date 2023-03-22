package com.pidev.welend.Controllers;

import com.pidev.welend.Security.Config.JwtUtils;
import com.pidev.welend.dto.AuthentificationRequest;
import com.pidev.welend.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthentificationController {
    private final AuthenticationManager authenticationManager;
    private final Users userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String>authenticate(@RequestBody AuthentificationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
final UserDetails user = userDao.findUserByEmail(request.getEmail());
if (user != null){
    return ResponseEntity.ok(jwtUtils.generateToken(user));
}
return ResponseEntity.status(400).body("Error");
    }
}
