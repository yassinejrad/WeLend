/*package com.pidev.welend.services;

import com.pidev.welend.entities.Users;
import com.pidev.welend.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    UsersRepo usersRepo;

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

    @Override
    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS.stream().filter(u -> u.getUsername().equals(email)).findFirst().orElseThrow(() -> new UsernameNotFoundException("No User Found"));
    }


    @Override
    public Users addUser(Users u) {
        return usersRepo.save(u);
    }

    @Override
    public Users updateUser(Users u) {
        return usersRepo.save(u);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public Users getUserByID(Integer UserID) {
        return usersRepo.findById(UserID).orElse(null);
    }

    @Override
    public void deleteUser(Integer UserID) {
        usersRepo.deleteById(UserID);
    }
}
*/