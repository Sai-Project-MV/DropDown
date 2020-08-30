package com.mangesh.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.mangesh.repository.CountryRepository;
import com.mangesh.repository.StateRepository;

//@RestController
//@RequestMapping("/country")
public class CountryRestController {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@GetMapping("/all")
	public List<Object[]> fetchAllCountry() {
		return countryRepository.getAllCountries();

	}

	@GetMapping("/state")
	public List<Object[]> fetchOneRecord(@PathParam(value = "countryId") Integer countryId) {
		return countryRepository.getStatesByCountry(countryId);
	}

	@GetMapping("/city")
	public List<Object[]> fetchCityByUsingStateId(@PathParam(value = "stateId") Integer stateId) {
		return stateRepository.getCitiesByState(stateId);
	}
	/*
	 * @PostMapping("/cscStore") public Country storeCountryStateCity(@RequestBody
	 * Country country) { return countryRepository.save(country); }
	 * 
	 * @GetMapping("/all") public List<Country> getAllRecord() { return
	 * countryRepository.findAll(); }
	 */
	
}
