package at.fh.swenga.jpa.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.dao.RecruitRepository;
import at.fh.swenga.jpa.model.PlayerModel;

@Controller
public class RecruitController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	RecruitRepository recruitRepository;
	
	@RequestMapping(value = "/recruits", method = RequestMethod.GET)
	  public String handleRecruits(Model model, Principal principal ) {
		 
	      String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("player", player);

	      model.addAttribute("recruits",recruitRepository.findByPlayerUsername(name));
	      
		return "recruits";
	}
}


