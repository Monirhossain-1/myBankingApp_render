package com.example.MyBankingProject.service;


import com.example.MyBankingProject.entity.UserOld;
import com.example.MyBankingProject.repository.UserRepositoryOld;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceOld {


    private final UserRepositoryOld userRepo;


    public UserServiceOld(UserRepositoryOld userRepo) {
        this.userRepo = userRepo;
    }


    public UserOld createUser(UserOld user) {
        return userRepo.save(user);
    }


    public List<UserOld> getUsers() {
        return userRepo.findAll();
    }


    public UserOld getUserById(Long id) {
        return userRepo.findById(id).orElseThrow();
    }


    public UserOld updateUser(Long id, UserOld userDetails) {
        UserOld user = userRepo.findById(id).orElseThrow();
        user.setFullName(userDetails.getFullName());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setAddress(userDetails.getAddress());
        user.setRole(userDetails.getRole());
        user.setStatus(userDetails.getStatus());
        return userRepo.save(user);
    }


    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
