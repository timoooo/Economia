package at.fh.swenga.jpa.controller;

import java.util.List;
import java.util.Set;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.model.ActionModel;
import at.fh.swenga.jpa.model.BuildingModel;
import at.fh.swenga.jpa.model.CompanyModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.ResourceModel;
import at.fh.swenga.jpa.model.RobotModel;

@Controller
public class TickController {

	int tick;
	
	@Autowired
	PlayerRepository playerRepository;

	@RequestMapping(value ="/tick" , method = RequestMethod.GET)
	@Transactional
	public String tick() {
		long count = 0;
		List<PlayerModel> users = null;
		users = playerRepository.findAll();
		
		//jeden player durchgehen und die Ressourcen erhöhen
		for(PlayerModel player : users) {
			int woodGain = 0;
			int stoneGain = 0;
			int foodGain = 0;
			int goldGain = 0;
			
			for (BuildingModel playerBuilding: player.getBuildings()){
				woodGain += playerBuilding.getWoodOutput();
				stoneGain += playerBuilding.getStoneOutput();
				foodGain += playerBuilding.getFoodOutput();
				goldGain += playerBuilding.getGoldOutput();
			}


			ResourceModel resources = new ResourceModel();
			resources.setPlayer(player);
			resources.setWood(player.getResources().getWood() + woodGain);
			resources.setStone(player.getResources().getStone() + stoneGain);
			resources.setFood(player.getResources().getFood() + foodGain);
			resources.setGold(player.getResources().getGold() + goldGain);
			
			player.setResources(resources);
			playerRepository.save(player);
			
			count +=1;
			
			//check for new construction action
			Set<ActionModel> actions = player.getActions();
			if(actions.size()>0){
				for (ActionModel action: actions){
					switch (action.getType()){
						case 'b': System.out.println("create new Building");
						case 'x': System.out.println("create new Troops");
						case 'f': System.out.println("create new Fight");
						case 't': System.out.println("create new Trade");
					}
						
				}
			}

			//brauchen Datenbank für buildings und units, die erstellt werden können....
			//brauchen Datenbank für aktuelle Actions! oda ka wies sonst gespeichert wird...
		}
		tick +=1;
		if(tick==1000000000) tick = 0;
		System.out.println("New Tick: " + tick);
		return "index"; //count
	}
}