package com.example.MyBankingProject.dtos;

import com.example.MyBankingProject.entity.Role;

import java.util.List;

public record AdminStatistics(long totalUsers, long enabledUsers, List<Role> roles) {
}
