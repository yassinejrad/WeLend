package com.pidev.welend.Controllers;

import com.pidev.welend.entities.Users;
import com.pidev.welend.services.ClientService;
import com.pidev.welend.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;
    @Autowired
    ClientService clientService;


    @PutMapping("/update")
    public Users updateUser(@RequestBody Users u){
        return usersService.updateUser(u);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer UserID){
        usersService.deleteUser(UserID);
    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/getById/{id}")
    public Users getByUser(@PathVariable("id") Integer UserID)
    {
        return usersService.getUserByID(UserID);
    }
    @GetMapping("/getAllClients")
    public List<Users> getAllUsersByRoleClient() {
        return usersService.getAllUsersByRoleClient();
    }


}
