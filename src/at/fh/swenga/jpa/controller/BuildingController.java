package at.fh.swenga.jpa.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.BuildingRepository;
import at.fh.swenga.jpa.dao.HistoryRepository;
import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.dao.PlayerRoleRepository;
import at.fh.swenga.jpa.model.BuildingModel;
import at.fh.swenga.jpa.model.HistoryModel;
import at.fh.swenga.jpa.model.PlayerModel;

@Controller
public class BuildingController {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	BuildingRepository buildingRepository;
	
	@Autowired
	PlayerRoleRepository playerRoleRepository;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@RequestMapping(value = "/buildings", method = RequestMethod.GET)
	@Transactional 
	public String handleBuildings(Model model, Principal principal ) {
		 
      model.addAttribute("player", getPlayerModel(principal));	      
      model.addAttribute("buildings",buildingRepository.findByPlayerUsername(principal.getName()));
	return "buildings";
	}
	
	
	@RequestMapping(value = "/buildingsOffer", method = RequestMethod.GET)
	@Transactional 
	public String handleBuildingsOffer(Model model, Principal principal ) {
		 
      model.addAttribute("player", getPlayerModel(principal));	  
      model.addAttribute("buildings",getAdminBuildings());
	      
	return "buildingsOffer";
	}
		
	@RequestMapping(value = "/addOrUpgradeBuilding",  method = RequestMethod.GET)
	@Transactional
	public String addBuilding( Model model, Principal principal, @RequestParam int id ) {
		boolean upgradeInsteadOfAdd = false;
		String successMessage = null;
		String historyMsg = "";
		
		try{
		PlayerModel player = getPlayerModel(principal);
		
		BuildingModel newBuilding = buildingRepository.getBuildingById(id);
		
		//upgrade eines Gebäudes durchführen, wenn es uns bereits gehört
		if (newBuilding.getPlayer() == player) {
			upgradeInsteadOfAdd = true;
		}
		else	//checken ob Building gefunden wurde und von Admin erstellt wurde
		if (!newBuilding.getPlayer().getUsername().equals("admin")) {
			model.addAttribute("errorMessage", "Wrong Building-ID received!<br>");
			return "forward:/buildings";
		}
			
		
		//neue Ressourcen berechnen
		int woodLeft = player.getWood()-newBuilding.getNeededWood();
		int stoneLeft = player.getStone()-newBuilding.getNeededStone();
		int foodLeft = player.getFood()-newBuilding.getNeededFood();
		int goldLeft = player.getGold()-newBuilding.getNeededGold();
		
		//Überprüfen, ob zu wenig Ressourcen verfügbar sind
		if(woodLeft<0){ model.addAttribute("errorMessage", "Wood stocks are too low Sire!!<br>"); 	return "forward:/buildings";}
		if(stoneLeft<0){ model.addAttribute("errorMessage", "Stone stocks are too low Sire!!<br>"); return "forward:/buildings";}
		if(foodLeft<0){ model.addAttribute("errorMessage", "Food stocks are too low Sire!!<br>"); 	return "forward:/buildings";}
		if(goldLeft<0){ model.addAttribute("errorMessage", "Not enough Gold Sire!!<br>"); 			return "forward:/buildings";}
		
		//building clonen oder level up UND WERTE ERHÖHEN
		if(upgradeInsteadOfAdd) {
			newBuilding.levelUp();
			newBuilding.setWoodOutput((int) (newBuilding.getWoodOutput()*2));
			newBuilding.setStoneOutput((int) (newBuilding.getStoneOutput()*1.7));
			newBuilding.setFoodOutput((int) (newBuilding.getFoodOutput()*1.5));
			newBuilding.setGoldOutput((int) (newBuilding.getGoldOutput()*1.2));
			
			successMessage = "Building \"" + newBuilding.getName() + "\" has been upgraded my Lord :)";
			historyMsg = "You upgraded a building (id" +newBuilding.getId()+") to level " + newBuilding.getLevel();
			
		}
		else {
			//neues Object, da neues Gebäude -> clone
			newBuilding = newBuilding.clone();
			//in History speichern
			successMessage = "New building \"" + newBuilding.getName() + "\" has been built my Lord :D";
			historyMsg = "You build a new building (id" +newBuilding.getId()+")";
		}
		
		
		//neue ResourcWerte setzen (die building werte für ein späteres upgrade)
		player.setWood(woodLeft);	newBuilding.setNeededWood((int) (newBuilding.getNeededWood()*1.8));
		player.setStone(stoneLeft); newBuilding.setNeededStone((int) (newBuilding.getNeededStone()*1.8));
		player.setFood(foodLeft); 	newBuilding.setNeededFood((int) (newBuilding.getNeededFood()*1.8));
		player.setGold(goldLeft);	newBuilding.setNeededGold((int) (newBuilding.getNeededGold()*1.8));
		
		
		//in der History vermerken
		player = addHistoryEntry(player,historyMsg,"construct");
		
		//player hinzufügen
		newBuilding.setPlayer(player);
		player.addBuilding(newBuilding);
		//in db speichern
		playerRepository.save(player);
		buildingRepository.save(newBuilding);
		
		

		
		model.addAttribute("message",successMessage);
				 
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
	
	private List<BuildingModel> getAdminBuildings(){
	      return buildingRepository.findByPlayerUsername("admin");
	}
	
	
	private PlayerModel addHistoryEntry (PlayerModel player, String message, String type){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df; 
        df = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");     // 31.01.2016 20:07
		
		HistoryModel history = new HistoryModel(); 
		history.setPlayer(player);
		history.setInfo(message);
		history.setType(type);
		history.setDate(now.format(df));
		player.addHistory(history);
		historyRepository.save(history);
		return player;
	}
	
	
	
}