package com.bankapplication.service;

import java.util.List;

import com.bankapplication.model.District;




public interface DistrictService {
    public List<District> getDistrictsByStateId(int stateId);
}
