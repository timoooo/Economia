package at.fh.swenga.jpa.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.BuildingRepository;
import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.model.BuildingModel;
import at.fh.swenga.jpa.model.PlayerModel;

@Controller
public class BuildingController {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	BuildingRepository buildingRepository;
	
	@RequestMapping(value = "/buildings", method = RequestMethod.GET)
	  public String handleBuildings(Model model, Principal principal ) {
		 
	      String name = principal.getName(); //get logged in username
	      
	      //Hibernate.initialize(PlayerModel.getBuildings());
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("player", player);
	      
	      
	      model.addAttribute("buildings",buildingRepository.findByPlayerUsername(name));

	      
		return "buildings";
		}
		
	@RequestMapping(value = "/addBuilding", method = RequestMethod.POST)
	public String addBuilding(@Valid @ModelAttribute  BuildingModel newBuildingModel, BindingResult bindingResult,
			Model model) {
 
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);
			return "forward:/builings";
		}
 
		/*
		BuildingModel building = BuildingRepository.getBuilding(newEmployeeModel.getSsn());
 
		if (building != null) {
			model.addAttribute("errorMessage", "Employee already exists!<br>");
		} else {*/
		
		//employeeManager.addEmployee(newEmployeeModel);
		//model.addAttribute("message", "New employee " + newEmployeeModel.getSsn() + " added.");
		
 
		return "forward:/buildingSuccess";
		}
	
	
	@RequestMapping(value = "/addBuilding", method = RequestMethod.GET)
	public String showAddBuildingForm(Model model) {
		return "newBuilding";
	}
	
	
	
	
}