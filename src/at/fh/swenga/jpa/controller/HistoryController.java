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
public class HistoryController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	  public String handleHistory(Model model, Principal principal ) {
		 
	      String name = principal.getName(); //get logged in username
	      model.addAttribute("username", name);
	      
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("aa", player.getWood());
	      model.addAttribute("bb", player.getWood());
	      model.addAttribute("wood", player.getWood());
	      model.addAttribute("stone", player.getStone());
	      model.addAttribute("food", player.getFood());
	      model.addAttribute("gold", player.getGold());
	      
		return "history";
	}
}


