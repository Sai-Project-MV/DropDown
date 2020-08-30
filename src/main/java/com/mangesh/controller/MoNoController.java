package com.mangesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mangesh.repository.CountryRepository;
import com.mangesh.repository.StateRepository;

@Controller
public class MoNoController {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping("/all")
	public String showPage(Model model) {
		model.addAttribute("countryList", countryRepository.getAllCountries());
		return "Register";
	}
	
	@GetMapping("/getStates")
	public @ResponseBody String getStates(@RequestParam Integer countryId)
	{
		String json = null;
		List<Object[]> list = countryRepository.getStatesByCountry(countryId);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@GetMapping("/getCities")
	public @ResponseBody String getCities(@RequestParam Integer stateId)
	{
		String json = null;
		List<Object[]> list = stateRepository.getCitiesByState(stateId);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
