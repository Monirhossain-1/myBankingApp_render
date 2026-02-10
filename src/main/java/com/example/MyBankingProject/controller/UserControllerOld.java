//package com.example.MyBankingProject.controller;
//
//
//import com.example.MyBankingProject.entity.UserOld;
//import com.example.MyBankingProject.service.UserServiceOld;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//@CrossOrigin
//public class UserControllerOld {
//
//
//    private final UserServiceOld userServiceOld;
//
//
//    public UserControllerOld(UserServiceOld userServiceOld) {
//        this.userServiceOld = userServiceOld;
//    }
//
//
//    @PostMapping
//    public UserOld createUser(@RequestBody UserOld user) {
//        return userServiceOld.createUser(user);
//    }
//
//
//    @GetMapping
//    public List<UserOld> getAllUsers() {
//        return userServiceOld.getUsers();
//    }
//
//
//    @GetMapping("/{id}")
//    public UserOld getUser(@PathVariable Long id) {
//        return userServiceOld.getUserById(id);
//    }
//
//
//    @PutMapping("/{id}")
//    public UserOld updateUser(@PathVariable Long id, @RequestBody UserOld user) {
//        return userServiceOld.updateUser(id, user);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        userServiceOld.deleteUser(id);
//    }
//}