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

		//String name = principal.getName(); // get logged in username
		String name = "user";
		PlayerModel player = playerRepository.findByUsername(name);
		model.addAttribute("player", player);

		model.addAttribute("recruits", recruitRepository.findByPlayerUsername(name));

		return "recruits";
		// String name = principal.getName(); // get logged in username

		// String name = "user";
		// PlayerModel player = playerRepository.findByUsername(name);
		// model.addAttribute("player", player);
		// System.out.print("Anlegen des der Liste");
		// try {
		// // List<RecruitModel> units = player.getUnits();
		// // falls das erste mal initiated
		// // if (unit.isEmpty()) {
		//
		// // }
		//
		// // model.addAttribute("recruits", units);
		// } catch (Exception e) {
		//
		// // System.out.print("Anlegen des Models");
		// // RecruitModel recruit = new RecruitModel();
		// // List<RecruitModel> recruits = recruit.getUnits();
		// // model.addAttribute("recruits", recruits);
		// // recruitRepository.save(recruits);
		//
		// System.out.println("ERROR");
		//
		// }
		// //
		// model.addAttribute("recruits",recruitRepository.findByPlayerUsername(name));
		//
		// return "recruits";
	}

	@RequestMapping(value = "/submitrecruits", method = RequestMethod.GET)
	public String submitRecruits(Model model, Principal principal, @RequestParam int addUnit1,
			@RequestParam int addUnit2, @RequestParam int addUnit3, @RequestParam int addUnit4,
			@RequestParam int addUnit5) {
		// speichern der recruits
		System.out.println("SUCCESS");
		// for (RecruitModel recruit : recruits) {
		// }
		System.out.println(addUnit1);
		String name = "user";
		// String name = principal.getName();
		// System.out.println(name);
		// PlayerModel player = playerRepository.findByUsername(name);
		// List<RecruitModel> recruits =
		// recruitRepository.findByPlayerUsername(name);
		// System.out.println(recruits.size());
		//
		// for (RecruitModel recruit : recruits) {
		// int id = recruit.getId();
		// System.out.println("This is the id" + id);
		// switch (recruit.getId()) {
		//
		// case 1: {
		// System.out.println("Footman");
		// System.out.println(recruit.getCount());
		// recruit.setCount(recruit.getCount() + addUnit1);
		// System.out.println(recruit.getCount());
		// }
		// case 2:
		// case 3:
		// case 4:
		// case 5:
		// default:System.out.println("HELLO");
		// }
		//
		// String recruitName = recruit.getName();
		// System.out.println(recruitName);
		// // if (recruitName.equals("Footman") == true) {
		// // System.out.println("Footman");
		// // System.out.println(recruit.getCount());
		// // recruit.setCount(recruit.getCount() + addUnitFootman);
		// // System.out.println(recruit.getCount());
		// // } else if (addUnitArcher > 0) {
		// // recruit.setCount(recruit.getCount() + addUnitArcher);
		// // } else if (addUnit2Handed > 0) {
		// // recruit.setCount(recruit.getCount() + addUnit2Handed);
		// // } else if (addUnitKnight > 0) {
		// // recruit.setCount(recruit.getCount() + addUnitKnight);
		// // } else if (addUnitLongbowArcher > 0) {
		// // recruit.setCount(recruit.getCount() + addUnitLongbowArcher);
		// // }
		//
		// }
		//recruitRepository.save(recruits);
		//model.addAttribute("recruits", recruits);

		return "redirect:recruits";
	}

}
