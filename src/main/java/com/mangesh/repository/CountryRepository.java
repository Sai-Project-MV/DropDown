package com.mangesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mangesh.model.Country;
import java.lang.Integer;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	@Query("SELECT c.countryId,c.countryName FROM Country c")
	List<Object[]> getAllCountries();
	
	@Query("SELECT s.stateId,s.stateName FROM Country c JOIN c.state AS s WHERE c.countryId=:id")
	List<Object[]> getStatesByCountry(Integer  id);
}
