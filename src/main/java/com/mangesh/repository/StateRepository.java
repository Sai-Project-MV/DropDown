package com.mangesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mangesh.model.State;
import java.lang.Integer;
import java.util.List;

public interface StateRepository extends JpaRepository<State, Integer> {

	@Query("SELECT c.cityId,c.cityName FROM State s JOIN s.city AS c WHERE s.stateId=:id")
	List<Object[]> getCitiesByState(Integer id);

}
