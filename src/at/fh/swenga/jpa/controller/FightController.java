package at.fh.swenga.jpa.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.dao.RecruitRepository;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.RecruitModel;

@Controller
public class FightController {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	RecruitRepository recruitRepository;

	@RequestMapping(value = "/fight", method = RequestMethod.GET)
	public String handleFight(Model model, Principal principal) {
		try {
			String name = principal.getName(); // get logged in username
			PlayerModel player = playerRepository.findByUsername(name);
			model.addAttribute("player", player);

			List<PlayerModel> players = getPlayerlist2Fight(player,model);

			// players= playerRepository.findByDeffPowerUnits(15);
			for (PlayerModel player1 : players) {
				System.out.println(player1.getUsername());
			}

		
			// model.addAttribute("winchance",ds);
			model.addAttribute("players", players);
			playerRepository.save(player);
			return "fight";
		} catch (Exception e) {
			return "login";
		}
	}
	//PUSH COMMENT 
	@RequestMapping(value = "/fightnow", method = RequestMethod.GET)
	public String calcWinnerAndLoser(Model model, Principal principal, @RequestParam String username) {
		/*
		 * 1. calc winner 2. set won ress 3. set loser lost ress 4. set loser
		 * lost units
		 * 
		 */
		String name = principal.getName();
		PlayerModel player1 = playerRepository.findByUsername(name);
		PlayerModel player2 = playerRepository.findByUsername(username);
		// calc fightpower for player 1
		int player1fightPower = player1.getAttackPowerUnits() + player1.getAccuracyUnits();
		// calc fightpower for player 2
		// NUR FÜR FILL MIT DATAFACTORY
		int player2fightPower = player2.getDeffPowerUnits() + player2.getAccuracyUnits();
		int powerOverall = player1fightPower + player2fightPower;
		int playerWinChance = (player1fightPower * 100 / powerOverall);
		int playerWonRounds = 50;

		Random random = new Random();

		for (int i = 0; i <= 100; i++) {
			int rand = random.nextInt(100) + 1;
			if (rand < playerWinChance) {
				playerWonRounds += 1;
				System.out.println(playerWonRounds);
			} else {
				playerWonRounds -= 1;
				System.out.println(playerWonRounds);
			}
		}
		System.out.println(playerWonRounds);
		if (playerWonRounds > 50) {
			// player 1 won model attribut setzen rohstoffe++ verteidiger
			// rohstoff--

			System.out.println("Player1 won");
			// calc gained and lost ressources

			Double lostGold = (double) (player2.getGold() * 0.25);
			Double lostStone = (double) (player2.getStone() * 0.25);
			Double lostFood = (double) (player2.getFood() * 0.25);
			Double lostWood = (double) (player2.getWood() * 0.25);

			// player 1 hinzufügen
			player1.setGold(player1.getGold() + lostGold.intValue());
			player1.setStone(player1.getStone() + lostStone.intValue());
			player1.setFood(player1.getFood() + lostFood.intValue());
			player1.setWood(player1.getWood() + lostWood.intValue());

			// playyer 2 entfernen
			player2.setGold(player2.getGold() - lostGold.intValue());
			player2.setStone(player2.getStone() - lostStone.intValue());
			player2.setFood(player2.getFood() - lostFood.intValue());
			player2.setWood(player2.getWood() - lostWood.intValue());

			model.addAttribute("winner","smth");
			model.addAttribute("gold", lostGold.intValue());
			model.addAttribute("stone", lostStone.intValue());
			model.addAttribute("food", lostFood.intValue());
			model.addAttribute("wood", lostWood.intValue());
			model.addAttribute("loser", null);
			

		} else {
			// player 2 won model attribut setzen
			System.out.println("Player2 won");

			List<RecruitModel> units = recruitRepository.findByPlayerUsername(name);

			for (RecruitModel unit : units) {
				int newcount = 0;
				switch (unit.getUnitID()) {
				case 1:
					newcount = (int) (unit.getCount() * 0.8);
					int lost1 = unit.getCount() - newcount;
					unit.setCount(newcount);
					model.addAttribute("lost1",lost1);

					break;
				case 2:
					newcount = (int) (unit.getCount() * 0.8);
					int lost2 = unit.getCount() - newcount;
					unit.setCount(newcount);
					model.addAttribute("lost2",lost2);
					break;
				case 3:
					newcount = (int) (unit.getCount() * 0.8);
					int lost3 = unit.getCount() - newcount;
					unit.setCount(newcount);
					model.addAttribute("lost3",lost3);
					break;
				case 4:
					newcount = (int) (unit.getCount() * 0.8);
					int lost4 = unit.getCount() - newcount;
					unit.setCount(newcount);
					model.addAttribute("lost4",lost4);
					break;
				case 5:
					newcount = (int) (unit.getCount() * 0.8);
					int lost5 = unit.getCount() - newcount;
					unit.setCount(newcount);
					model.addAttribute("lost5",lost5);
					break;
				}

			}
			
			model.addAttribute("winner",null);
			model.addAttribute("loser","smth");
			
			
		}
		
		
		
		model.addAttribute("player",player1);
		List<PlayerModel> players = getPlayerlist2Fight(player1, model);
		model.addAttribute("players",players);
		playerRepository.save(player1);
		playerRepository.save(player2);
		return "fight";
	}

	public int calcFightPower(String type, PlayerModel player) {
		List<RecruitModel> units = new ArrayList<RecruitModel>();
		String name = player.getUsername();
		units = recruitRepository.findByPlayerUsername(name);
		int fightPower = 0;
		switch (type) {
		case "atk": {
			// fightPower neu berechnen und setzen
			for (RecruitModel unit : units) {
				fightPower = fightPower + (unit.getCount() * unit.getAttackPower());
				player.setAttackPowerUnits(fightPower);

			}
			break;
		}

		case "deff": {
			// fightPower neu berechnen und setzen
			for (RecruitModel unit : units) {
				fightPower = fightPower + (unit.getCount() * unit.getDeffPower());
				player.setDeffPowerUnits(fightPower);

			}
			break;
		}
		case "acc": {
			int quantity = 0;

			for (RecruitModel unit : units) {
				fightPower += (unit.getCount() * unit.getAccuracy());
				quantity += unit.getCount();
			}
			try {
				fightPower = fightPower / quantity;
			} catch (ArithmeticException e) {
				fightPower = 0;
				System.out.print("Keine Einheiten vorhanden");

			}
			break;

		}
		default:
			System.out.println("BRUUUUUUUUUUH");

		}

		return fightPower;
	}
	
	
	public List<PlayerModel> getPlayerlist2Fight(PlayerModel player, Model model){
		int attack = calcFightPower("atk", player);
		int deff = calcFightPower("deff", player);
		int acc = calcFightPower("acc", player);
		player.setAttackPowerUnits(attack);
		player.setDeffPowerUnits(deff);
		player.setAccuracyUnits(acc);
		
		Double deffLower = attack * 0.8;
		Double deffHigher = attack * 1.2;
		int intDeffLower = deffLower.intValue();
		int intDeffHigher = deffHigher.intValue();
		System.out.println(intDeffLower - intDeffHigher);
		List<PlayerModel> players = new ArrayList<PlayerModel>();
		players = playerRepository.findByDeffPowerUnitsBetween(intDeffLower, intDeffHigher);
		model.addAttribute("attack", attack);
		model.addAttribute("defense", deff);
		model.addAttribute("acc", acc);
		
		//den eigenen player ausblenden
		for(PlayerModel playerx:players){
		      if(playerx.getUsername().equals(player.getUsername())){
		        players.remove(playerx);
		      }
		    }
		return players;
	}
	
	
}
