package com.example.MyBankingProject.controller;

import com.example.MyBankingProject.entity.Branch;
import com.example.MyBankingProject.service.BranchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@CrossOrigin(origins = "http://localhost:4200") // Angular access
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    // ADD branch
    @PostMapping
    public Branch addBranch(@RequestBody Branch branch) {
        return branchService.addBranch(branch);
    }

    // GET all branches
    @GetMapping
    public List<Branch> getBranches() {
        return branchService.getAllBranches();
    }

    // DELETE branch
    @DeleteMapping("/{id}")
    public String deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return "Branch deleted successfully";
    }
}