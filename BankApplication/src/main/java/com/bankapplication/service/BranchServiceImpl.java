package com.bankapplication.service;

import com.bankapplication.dto.RequstBranchDto;
import com.bankapplication.dto.ResponseBranchDto;
import com.bankapplication.model.Branch;
import com.bankapplication.repository.BranchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    /**
     * Retrieves a branch by its ID.
     *
     * @param id the ID of the branch
     * @return the branch if found
     * @throws NoSuchElementException if no branch is found with the given ID
     */
    public Branch getBranchById(int id) {
	logger.info("getBranchById method called with ID: {}", id);

	// Find branch by ID using the repository
	Optional<Branch> branch = branchRepository.findById(id);
// Check if the branch is present
	if (branch.isPresent()) {
	    logger.info("Branch with ID: {} found.", id);
	    return branch.get();
	} else {
	    logger.error("Branch with ID: {} not found.", id);
	    throw new NoSuchElementException("Branch with ID " + id + " not found.");
	}
    }

    /**
     * Converts a Branch object to a RequestBranchDto object.
     *
     * @param branch the Branch object to be converted
     * @return the converted RequestBranchDto object
     */
    public RequstBranchDto branchToRequestDTO(Branch branch) {
	logger.info("branchToRequestDTO method called");
	// Create a new RequestBranchDto object
	RequstBranchDto requstBranchDto = new RequstBranchDto();

	try {
	    // Set the branch name
	    requstBranchDto.setBranchName(branch.getBranchName());
	    logger.info("Branch name set: {}", branch.getBranchName());

	    // Set the contact number
	    requstBranchDto.setContactNo(branch.getContactNo());
	    logger.info("Contact number set: {}", branch.getContactNo());

	    // Set the email
	    requstBranchDto.setEmail(branch.getEmail());
	    logger.info("Email set: {}", branch.getEmail());

	    // Retrieve and set the city ID
	    Integer cityId = branch.getCity().getId();
	    requstBranchDto.setCityid(cityId.toString());
	    logger.info("City ID set: {}", cityId);
	} catch (NullPointerException e) {
	    logger.error("Null value encountered: {}", e.getMessage());
	    throw new IllegalArgumentException("Branch object contains null values", e);
	} catch (Exception e) {
	    logger.error("Exception occurred: {}", e.getMessage());
	    throw new RuntimeException("Failed to convert Branch to RequestBranchDto", e);
	}

	return requstBranchDto;
    }

    /**
     * Converts a Branch object to a ResponseBranchDto object.
     *
     * @param branch the Branch object to be converted
     * @return the converted ResponseBranchDto object
     */
    public ResponseBranchDto branchToResponseDto(Branch branch) {
	// Create a new ResponseBranchDto object
	ResponseBranchDto responseBranchDto = new ResponseBranchDto();

	try {
	    // Set the branch ID
	    responseBranchDto.setId(branch.getId());
	    logger.info("Branch ID set: {}", branch.getId());

	    // Set the branch name
	    responseBranchDto.setBranchName(branch.getBranchName());
	    logger.info("Branch name set: {}", branch.getBranchName());

	    // Set the city name
	    responseBranchDto.setCityName(branch.getCity().getCityName());
	    logger.info("City name set: {}", branch.getCity().getCityName());

	    // Set the contact number
	    responseBranchDto.setContactNo(branch.getContactNo());
	    logger.info("Contact number set: {}", branch.getContactNo());

	    // Set the email
	    responseBranchDto.setEmail(branch.getEmail()); // Corrected
	    logger.info("Email set: {}", branch.getEmail());

	    // Set the manager ID
//            int managerid = branch.getManagerId().getId();
//            Integer managerid2 = managerid;
//            responseBranchDto.setManagerId(managerid2.toString());
//            logger.info("Manager ID set: {}", branch.getManagerId().getId());

	} catch (NullPointerException e) {
	    logger.error("Null value encountered: {}", e.getMessage());
	    throw new IllegalArgumentException("Branch object contains null values", e);
	} catch (Exception e) {
	    logger.error("Exception occurred: {}", e.getMessage());
	    throw new RuntimeException("Failed to convert Branch to ResponseBranchDto", e);
	}

	return responseBranchDto;
    }

}
