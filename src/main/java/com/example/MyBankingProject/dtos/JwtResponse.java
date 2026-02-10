package com.example.MyBankingProject.dtos;



import com.example.MyBankingProject.entity.User;

public record JwtResponse(
        String jwtToken,
        User user
//        String username,
//        String email,
//        Collection<String> roles
) {}