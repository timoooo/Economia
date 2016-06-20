package at.fh.swenga.jpa.controller;

import java.security.Principal;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.BuildingRepository;
import at.fh.swenga.jpa.dao.PlayerRepository;
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
}