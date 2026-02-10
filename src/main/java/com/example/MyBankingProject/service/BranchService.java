package com.example.MyBankingProject.service;

import com.example.MyBankingProject.entity.Branch;
import com.example.MyBankingProject.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    private final BranchRepository branchRepo;

    public BranchService(BranchRepository branchRepo) {
        this.branchRepo = branchRepo;
    }

    // Add Branch
    public Branch addBranch(Branch branch) {
        branch.setStatus("ACTIVE");
        return branchRepo.save(branch);
    }

    // Get All Branches
    public List<Branch> getAllBranches() {
        return branchRepo.findAll();
    }

    // Delete Branch
    public void deleteBranch(Long id) {
        branchRepo.deleteById(id);
    }}
