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

		// String name = principal.getName(); // get logged in username
		String name = "user";
		PlayerModel player = playerRepository.findByUsername(name);
		model.addAttribute("player", player);

		model.addAttribute("recruits", recruitRepository.findByPlayerUsername(name));

		return "recruits";

	}

	@RequestMapping(value = "/submitrecruits", method = RequestMethod.GET)
	public String submitRecruits(Model model, Principal principal, @RequestParam int addUnit1,
			@RequestParam int addUnit2, @RequestParam int addUnit3, @RequestParam int addUnit4,
			@RequestParam int addUnit5) {
		// String name = principal.getName();
		String name = "user";
		PlayerModel player = playerRepository.findByUsername(name);
		List<RecruitModel> recruits = recruitRepository.findByPlayerUsername(name);
		for (RecruitModel recruit : recruits) {

			switch (recruit.getUnitID()) {

			case 1: {
				int i = recruit.getCount() + addUnit1;
				recruit.setCount(i);
			}
			case 2: {
				int i = recruit.getCount() + addUnit2;
				recruit.setCount(i);
			}
			case 3: {
				int i = recruit.getCount() + addUnit3;
				recruit.setCount(i);
			}
			case 4: {
				int i = recruit.getCount() + addUnit4;
				recruit.setCount(i);
			}
			case 5: {
				int i = recruit.getCount() + addUnit5;
				recruit.setCount(i);
			}
			default:
				System.out.println("HELLO");
			}
		}

		model.addAttribute("recruits", recruits);
		recruitRepository.save(recruits);

		return "recruits";
	}

}
