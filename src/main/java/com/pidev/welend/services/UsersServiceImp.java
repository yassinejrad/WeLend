package com.pidev.welend.services;

import com.pidev.welend.entities.Users;
import com.pidev.welend.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    UsersRepo usersRepo;

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
