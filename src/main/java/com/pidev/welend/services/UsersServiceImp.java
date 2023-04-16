package com.pidev.welend.services;

import com.pidev.welend.entities.Users;
import com.pidev.welend.entities.UsersType;
import com.pidev.welend.repos.UsersRepo;
import com.pidev.welend.security.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    UsersRepo usersRepo;

    @Autowired
	PasswordEncoder encoder;

    @Override
    public Users findUserByEmail(String email) {
      return usersRepo.getUserByEmail(email);
    }


    @Override
    public Users addUser(Users u) {
    	if (usersRepo.existsByUsername(u.getUsername())) {
			System.out.println("username existe");
		}

		if (usersRepo.existsByEmail(u.getEmail())) {
			System.out.println("username existe");
		}
		Users users = new Users(u.getUsername(), 
							 u.getEmail(),
							 encoder.encode(u.getPassword()));
		users.setRole(u.getRole());
		users.setEnable(true);
		users.setLocked(false);
		return usersRepo.save(users);
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
		
		return usersRepo.getById(UserID);
	}


	@Override
	public void deleteUser(Integer UserID) {
		usersRepo.deleteById(UserID);
		
	}
	@Override
	public List<Users> getAllUsersByRoleClient() {
		return usersRepo.findByRole(UsersType.CLIENT);
	}

}
