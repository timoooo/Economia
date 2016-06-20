package at.fh.swenga.jpa.controller;

import java.security.Principal;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import at.fh.swenga.jpa.dao.BuildingRepository;
import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.dao.RecruitRepository;
import at.fh.swenga.jpa.model.BuildingModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.RecruitModel;


@Controller
public class CastleController {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	BuildingRepository buildingRepository;
	
	@Autowired
	RecruitRepository recruitRepository;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}

	@RequestMapping(value = { "/", "list" })
	public String index(Model model, Principal principal) {
		String name = principal.getName(); // get logged in username
		model.addAttribute("username", name);

		PlayerModel player = playerRepository.findByUsername(name);
		List<PlayerModel> players = playerRepository.findAll();
		model.addAttribute("players", players);
		model.addAttribute("player", player);
		//model.addAttribute("type", "findAll");
		return "index";
	}
	
	@RequestMapping("/fill")
	@Transactional
	public String fillData(Model model) {

		DataFactory df = new DataFactory();
		PlayerModel player = null;
		
		
		String username = "user";

		for (int i = 0; i < 20; i++) {
			
			player = playerRepository.findByUsername(username);
			
			if (player == null) {
				player = new PlayerModel(username, df.getEmailAddress(), "password", "USER", df.getNumberUpTo(10000), df.getNumberUpTo(5000),df.getNumberUpTo(200), df.getNumberUpTo(100));
			
				for (int j = 0; j < 5; j++) {
					BuildingModel building = new BuildingModel(df.getRandomWord(10), "http://feudal-wars.s3.amazonaws.com/s3fs-public/buildings/English_Town%20Hall.png", df.getNumberUpTo(10), df.getNumberUpTo(20), df.getNumberUpTo(100), df.getNumberUpTo(50), df.getNumberUpTo(10), df.getNumberUpTo(100), df.getNumberUpTo(100), df.getNumberUpTo(100), df.getNumberUpTo(100));			
					building.setPlayer(player);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
					
					RecruitModel recruit = new RecruitModel(df.getRandomText(10, 20), "http://feudal-wars.s3.amazonaws.com/s3fs-public/unit_thumbs/thumb_4.png", df.getNumberUpTo(10), df.getNumberUpTo(10), df.getNumberUpTo(20), df.getNumberUpTo(30), df.getNumberUpTo(40), "castle", df.getNumberUpTo(20), df.getNumberUpTo(30), df.getNumberUpTo(80), df.getNumberUpTo(99));
					recruit.setPlayer(player);			//workaround, da das automatische setzen nicht funktioniert (auf drei Arten probiert, 6h weg)
					
					player.addRecruit(recruit);
					player.addBuilding(building);
					playerRepository.save(player);		
					buildingRepository.save(building);  	//siehe comment darüber
					recruitRepository.save(recruit);
				}
				System.out.println("BuildingModelize: " + player.getBuildings().size());
			
				//playerRepository.save(player);
			}
			username = df.getFirstName();
			
		}

		return "forward:list";
	}
}
