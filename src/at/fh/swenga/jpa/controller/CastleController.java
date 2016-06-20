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

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.model.BuildingModel;
import at.fh.swenga.jpa.model.CompanyModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.RobotModel;

@Controller
public class CastleController {

	@Autowired
	PlayerRepository playerRepository;



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}

	@RequestMapping(value = { "/", "list" })
	public String index(Model model, Principal principal) {
		String name = principal.getName(); // get logged in username
		model.addAttribute("username", name);

		PlayerModel player = playerRepository.findByUsername(name);
		model.addAttribute("wood", player.getWood());
		model.addAttribute("stone", player.getStone());
		model.addAttribute("food", player.getFood());
		model.addAttribute("gold", player.getGold());

		List<PlayerModel> players = playerRepository.findAll();
		model.addAttribute("players", players);
		//model.addAttribute("type", "findAll");
		return "index";
	}
	
	@RequestMapping("/fill")
	@Transactional
	public String fillData(Model model) {

		DataFactory df = new DataFactory();
		PlayerModel player = null;
		
		
		String username = "user";

		for (int i = 0; i < 100; i++) {
			
			player = playerRepository.findByUsername(username);

			if (player == null) {
				player = new PlayerModel(username, df.getEmailAddress(), "password", "USER", df.getNumberUpTo(10000), df.getNumberUpTo(5000),df.getNumberUpTo(200), df.getNumberUpTo(100));
			}
			for (int j = 0; j < 10; j++) {
				BuildingModel building = new BuildingModel(df.getRandomWord(10), df.getNumberUpTo(10), df.getNumberUpTo(200), df.getNumberUpTo(100), df.getNumberUpTo(50), df.getNumberUpTo(10), df.getNumberUpTo(100), df.getNumberUpTo(100), df.getNumberUpTo(100), df.getNumberUpTo(100));			
				player.addBuilding(building);
			}
			
			playerRepository.save(player);
			username = df.getFirstName();
			
		}

		return "forward:list";
	}
}
