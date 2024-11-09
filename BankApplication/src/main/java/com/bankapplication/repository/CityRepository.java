package com.bankapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapplication.model.City;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
	@Query("SELECT c FROM City c WHERE c.district.id = :districtId")
	List<City> findCitiesByDistrictId(@Param("districtId") int districtId);


	@Query("SELECT c FROM City c WHERE c.id = :id")
	City findByCityId(@Param("id") int id);



}
