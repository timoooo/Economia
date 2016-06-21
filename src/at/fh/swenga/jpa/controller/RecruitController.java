package at.fh.swenga.jpa.controller;

import java.security.Principal;
import java.util.List;

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
public class RecruitController {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	RecruitRepository recruitRepository;

	@RequestMapping(value = "/recruits", method = RequestMethod.GET)
	public String handleRecruits(Model model, Principal principal) {
		System.out.print("Hey");

		String name = principal.getName(); // get logged in username

		PlayerModel player = playerRepository.findByUsername(name);
		model.addAttribute("player", player);

		model.addAttribute("recruits", recruitRepository.findByPlayerUsername(name));

		return "recruits";

	}

	@RequestMapping(value = "/submitrecruits", method = RequestMethod.GET)
	public String submitRecruits(Model model, Principal principal, @RequestParam int addUnit1,
			@RequestParam int addUnit2, @RequestParam int addUnit3, @RequestParam int addUnit4,
			@RequestParam int addUnit5) {
		String name = principal.getName();
		// String name = "user";
		PlayerModel player = playerRepository.findByUsername(name);
		List<RecruitModel> recruits = recruitRepository.findByPlayerUsername(name);

		for (RecruitModel recruit : recruits) {

			switch (recruit.getUnitID()) {

			case 1:
				calcRessCosts(recruit, player, model, addUnit1);

			case 2:
				calcRessCosts(recruit, player, model, addUnit2);
			case 3:
				calcRessCosts(recruit, player, model, addUnit3);
			case 4:
				calcRessCosts(recruit, player, model, addUnit4);
			case 5:
				calcRessCosts(recruit, player, model, addUnit5);
			default:
				System.out.println("SMTH WENT WRONG  PLS DO NOT HACK US :((((");
			}
		}
		model.addAttribute("player", player);
		model.addAttribute("recruits", recruits);
		recruitRepository.save(recruits);

		return "recruits";
	}

	public String calcRessCosts(RecruitModel recruit, PlayerModel player, Model model, int addUnit) {
		if (recruit.getNeededGold() * addUnit >= player.getGold()
				&& recruit.getNeededStone() * addUnit >= player.getStone()
				&& recruit.getNeededFood() * addUnit >= player.getFood()
				&& recruit.getNeededWood() * addUnit >= player.getWood()) {
			// Units setzen
			int i = 0;
			int ressGold = 0;
			int ressWood = 0;
			int ressFood = 0;
			int ressStone = 0;
			i = recruit.getCount() + addUnit;
			recruit.setCount(i);
			// Rohstoffkosten berechnen
			ressFood = recruit.getNeededFood() * addUnit;
			ressGold = recruit.getNeededGold() * addUnit;
			ressStone = recruit.getNeededStone() * addUnit;
			ressWood = recruit.getNeededWood() * addUnit;

			player.setGold(player.getGold() - ressGold);
			player.setFood(player.getFood() - ressFood);
			player.setStone(player.getStone() - ressStone);
			player.setWood(player.getWood() - ressWood);
			
			model.addAttribute("success","units build");

		} else {

			// FEHLER
			model.addAttribute("errorRess", "To less ressources to recruit desired Units");
			return "recruits";

		}

		playerRepository.save(player);
		return "recruits";

	}

}
