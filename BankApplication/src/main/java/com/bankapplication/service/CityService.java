package com.bankapplication.service;


import java.util.List;

import com.bankapplication.model.City;





public interface CityService  {
    public List<City> getCitiesByDistrictId(int districtId) ;
}
