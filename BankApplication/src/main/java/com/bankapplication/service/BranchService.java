package com.bankapplication.service;

import com.bankapplication.dto.RequstBranchDto;
import com.bankapplication.dto.ResponseBranchDto;
import com.bankapplication.model.Branch;

import java.util.List;

public interface BranchService {
    public List<Branch> getAllBranch();

    public Branch getBranchById(int id);

    public RequstBranchDto branchToRequestDTO(Branch branch);

    public ResponseBranchDto branchToResponseDto(Branch branch);
}
