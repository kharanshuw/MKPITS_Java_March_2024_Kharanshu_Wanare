package com.bankapplication.service;

import java.util.List;

import com.bankapplication.model.State;

public interface StateService {
    public List<State> getStatesByCountryId(int countryId);
}
