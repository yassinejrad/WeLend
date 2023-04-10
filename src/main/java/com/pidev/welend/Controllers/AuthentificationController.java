package com.pidev.welend.Controllers;

import com.pidev.welend.Security.Config.JwtUtils;
import com.pidev.welend.entities.Users;
import com.pidev.welend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthentificationController {
  @Autowired
   private AuthenticationManager authenticationManager;

   @Autowired
   private  UsersService userDao;

   private  JwtUtils jwtUtils;


   @PostMapping("/authenticate")
   public ResponseEntity<String>authenticate(@RequestBody Users request){
       jwtUtils=new JwtUtils();
       System.out.println(request.getEmail()+" "+ request.getPwd());
       try{
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPwd()));
           System.out.println(request);
       }
       catch (Exception e){
           System.out.println(e);
       }
final UserDetails user = userDao.findUserByEmail(request.getEmail());
if (user != null){
   return ResponseEntity.ok(jwtUtils.generateToken(user));
}
return ResponseEntity.status(400).body("Error");
   }

   @GetMapping("/h")
   public ResponseEntity<String> SayHello(){
       return ResponseEntity.ok("Hello from oui api");
   }



}
