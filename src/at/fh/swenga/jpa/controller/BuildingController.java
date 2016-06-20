package at.fh.swenga.jpa.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	@Transactional 
	public String handleBuildings(Model model, Principal principal ) {
		 

	      model.addAttribute("player", getPlayerModel(principal));	      
	      model.addAttribute("buildings",buildingRepository.findByPlayerUsername(principal.getName()));

	      
		return "buildings";
		}
		
	@RequestMapping(value = "/addBuilding",  method = RequestMethod.GET)
	@Transactional
	public String addBuilding( Model model, Principal principal, @RequestParam int id ) {
 
		try{
		PlayerModel player = getPlayerModel(principal);
		
		BuildingModel newBuilding = buildingRepository.getBuildingById(id);

		
		//checken ob Building gefunden wurde und von Admin erstellt wurde
		if (!newBuilding.getPlayer().getRole().equals("ADMIN")) {
			model.addAttribute("errorMessage", "Wrong Building-ID received!<br>");
			System.out.println("ERORRRRRRRRRRRR  :"+ newBuilding.getPlayer().getRole());
			return "forward:/buildings";
		}
			
		
		//neue Ressourcen berechnen
		int woodLeft = player.getWood()-newBuilding.getNeededWood();
		int stoneLeft = player.getStone()-newBuilding.getNeededStone();
		int foodLeft = player.getFood()-newBuilding.getNeededFood();
		int goldLeft = player.getGold()-newBuilding.getNeededGold();
		
		//Überprüfen, ob zu wenig Ressourcen verfügbar sind
		if(woodLeft<=0){ model.addAttribute("errorMessage", "Wood stocks are too low Sire!!<br>"); 	return "forward:/builings";}
		if(stoneLeft<=0){ model.addAttribute("errorMessage", "Stone stocks are too low Sire!!<br>"); return "forward:/builings";}
		if(foodLeft<=0){ model.addAttribute("errorMessage", "Food stocks are too low Sire!!<br>"); 	return "forward:/builings";}
		if(goldLeft<=0){ model.addAttribute("errorMessage", "Not enough Gold Sire!!<br>"); 			return "forward:/builings";}
		
		//neue ResourcWerte setzen
		player.setWood(woodLeft);
		player.setStone(stoneLeft);
		player.setFood(foodLeft);
		player.setGold(goldLeft);
		
		//building clonen und player hinzufügen
		newBuilding = newBuilding.clone();
		
		newBuilding.setPlayer(player);
		player.addBuilding(newBuilding);
		playerRepository.save(player);
		buildingRepository.save(newBuilding);
		
		model.addAttribute("message", "New building " + newBuilding.getName() + " added.");
 
		return "forward:/buildings";
		
			
		} catch (NullPointerException e) {	
			model.addAttribute("errorMessage", "Can't get Data! NullPointerException<br>");		
			System.out.println(e);
			return "forward:/buildings";
		}
	}

	
	
	private PlayerModel getPlayerModel(Principal principal){
		return playerRepository.findByUsername(principal.getName());
	}
	
	
	
}