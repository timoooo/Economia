package at.fh.swenga.jpa.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.dao.TradeRepository;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.TradeModel;



@Controller
public class TradeController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	TradeRepository tradeRepository;
	
	@RequestMapping(value = "/trade", method = RequestMethod.GET)
	  public String handleTrade(Model model, Principal principal ) {
		 
	      String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("player", player);

	     
		return "trade";
	}
	
	@RequestMapping(value = "/trade", method = RequestMethod.POST)
	public String changeEmployee(@Valid @ModelAttribute TradeModel newOffer, BindingResult bindingResult,
			Model model, Principal principal ) {			//@RequestParam int addUnit1,
		//@RequestParam int addUnit2, @RequestParam int addUnit3, @RequestParam int addUnit4
 
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);
			return "forward:/trade";
		}
 
		PlayerModel player = playerRepository.findByUsername(principal.getName());
		if(player==newOffer.getPlayer()){
			System.out.println("YAAA BITCHJ!!!!");
		}
 
		return "forward:/trade";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}


