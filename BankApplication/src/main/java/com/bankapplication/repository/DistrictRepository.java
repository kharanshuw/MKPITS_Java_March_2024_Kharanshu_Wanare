package com.bankapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankapplication.model.District;
@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
	
    @Query("SELECT d FROM District d WHERE d.state.id = :stateId")
  public  List<District> findDistrictsByStateId(@Param("stateId") int stateId);


}
