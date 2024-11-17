package com.bankapplication.repository;

import com.bankapplication.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Integer> {
    
}
