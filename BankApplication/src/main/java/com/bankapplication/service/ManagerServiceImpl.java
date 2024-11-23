package com.bankapplication.service;

import com.bankapplication.dto.ManagerDto;
import com.bankapplication.repository.ManagerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

    private ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    /**
     * Retrieves a list of all ManagerDto objects.
     *
     * @return a list of ManagerDto objects
     */
    public List<ManagerDto> getAllManagers() {
        logger.info("getAllManagers method called");

        try {
            // Retrieve list of all ManagerDto objects from the repository
            List<ManagerDto> list = managerRepository.findAllManagers();
            logger.info("Successfully retrieved {} managers", list.size());

            return list;

        } catch (Exception e) {
            // Log and handle any potential exceptions
            logger.error("Exception occurred while retrieving managers: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve managers", e);
        }

    }
}
