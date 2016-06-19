package at.fh.swenga.jpa.controller;

import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.model.BuildingModel;
import at.fh.swenga.jpa.model.CompanyModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.RobotModel;

@Controller
public class TickController {

	int tick;
	
	@Autowired
	PlayerRepository playerRepository;

	@RequestMapping("/tick")
	@Transactional
	public long tick() {
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
			
			player.getRessources().setWood(player.getRessources().getWood() + woodGain);
			player.getRessources().setStone(player.getRessources().getStone() + stoneGain);
			player.getRessources().setFood(player.getRessources().getFood() + foodGain);
			player.getRessources().setGold(player.getRessources().getGold() + goldGain);
			
			count +=1;
			
			//brauchen Datenbank für buildings und units, die erstellt werden können....
			//brauchen Datenbank für aktuelle Actions! oda ka wies sonst gespeichert wird...
		}
		tick +=1;
		if(tick==1000000000) tick = 0;
		return tick; //count
	}
}