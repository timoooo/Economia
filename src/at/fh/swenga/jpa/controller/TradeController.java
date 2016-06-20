package at.fh.swenga.jpa.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.model.PlayerModel;

@Controller
public class TradeController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@RequestMapping(value = "/trade", method = RequestMethod.GET)
	  public String handleTrade(Model model, Principal principal ) {
		 
	      String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("player", player);

	     
		return "trade";
	}
}


