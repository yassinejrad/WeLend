package com.pidev.welend.services;

import com.pidev.welend.entities.Users;

import java.util.List;

public interface UsersService {
    public Users addUser(Users u);
    public Users updateUser(Users u);
    public List<Users> getAllUsers();
    public Users getUserByID(Integer UserID);
    public void deleteUser(Integer UserID);
}
