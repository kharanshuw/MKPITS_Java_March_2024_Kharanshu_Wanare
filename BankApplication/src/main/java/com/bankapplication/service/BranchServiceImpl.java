package com.bankapplication.service;

import com.bankapplication.model.Branch;
import com.bankapplication.repository.BranchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {
    private static final Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);

    private BranchRepository branchRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }


    /**
     * Retrieves all branches from the database.
     *
     * @return a list of all branches
     */
    @Override
    public List<Branch> getAllBranch() {
        logger.info("getAllBranch method called");

        try {
            // Retrieve the list of all branches
            List<Branch> branchList = branchRepository.findAll();

            // Log the number of branches retrieved
            logger.info("Number of branches retrieved: {}", branchList.size());

            return branchList;
        } catch (Exception e) {
            // Log the exception with a meaningful message
            logger.error("Exception occurred while retrieving branches: {}", e.getMessage());

            // Optionally, rethrow the exception or handle it accordingly
            throw e;
        }


    }
}
