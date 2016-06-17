package at.fh.swenga.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.model.PlayerModel;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration() {
		System.out.println("register controller1");
		return "reg";
	}

	// @RequestMapping(value = "/regProcess", method = RequestMethod.GET)
	// public String registrationProcess(@ModelAttribute("player") PlayerModel
	// player, Map map, HttpServletRequest request){
	// System.out.println("HELP");
	// System.out.println("username: " +player.getName());
	// return "regSuccess";
	// }
	@RequestMapping(value = "/regProcess")
	public String registrationProcess(Model model, @RequestParam String username, @RequestParam String email,
			@RequestParam String password) {
		System.out.println("HELP");
		if (username.isEmpty() || email.isEmpty() || password.isEmpty() == true) {
			System.out.println("Please fill up all fields");
			return "regFail";
		} else if (password.length() + 1 < 6 || password.length() + 1 > 30 || username.length() > 20
				|| email.length() > 70) {
			System.out.println("Please uses a correct length for yor input");
			return "regFail";
		}
		model.addAttribute("username", username);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		PlayerModel player = new PlayerModel();

		player.setName(username);
		player.setEmail(email);
		player.setPassword(password);

		return "regSuccess";
	}

}