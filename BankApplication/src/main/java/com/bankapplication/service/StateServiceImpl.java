package com.bankapplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.controller.AdminController;
import com.bankapplication.model.State;
import com.bankapplication.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {
	
	private static final Logger logger = LoggerFactory.getLogger(StateServiceImpl.class);

	private StateRepository stateRepository;

	@Autowired
	public StateServiceImpl(StateRepository stateRepository) {
		super();
		this.stateRepository = stateRepository;
	}

	
	/**
	 * Retrieves a list of states by the given country ID.
	 *
	 * @param countryId the ID of the country
	 * @return a list of states in the specified country
	 */
	@Override
	public List<State> getStatesByCountryId(int countryId) {
	    logger.info("getStatesByCountryId method called with countryId: {}", countryId);

	    //Retrieves a list of states by the given country ID.
		List<State> states = stateRepository.findByCountryId(countryId);
		
	    logger.info("Retrieved {} states for countryId: {}", states.size(), countryId);

		return states;
	}

}
