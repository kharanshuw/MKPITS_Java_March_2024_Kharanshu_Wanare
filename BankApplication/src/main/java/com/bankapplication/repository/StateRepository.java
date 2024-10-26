package com.bankapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import com.bankapplication.model.State;

@Repository
public interface StateRepository  extends JpaRepository<State, Integer>{

	@Query("SELECT s FROM State s WHERE s.country.id = :countryId")
	public List<State> findByCountryId(@Param("countryId") int countryId);
}
