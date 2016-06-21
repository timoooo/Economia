package at.fh.swenga.jpa.controller;

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
public class RegisterController {

//	@Autowired
//	RecruitRepository recruitRepository;

	@Autowired
	PlayerRepository playerRepository;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration() {
		System.out.println("register controller1");
		return "reg";
	}

	@RequestMapping(value = "/regProcess")
	public String registrationProcess(Model model, @RequestParam String username, @RequestParam String email,
			@RequestParam String password) {
		System.out.println("HELP");
		username = username.trim();
		email = email.trim();
		System.out.println("TRIMMED");

		// initialisieren des Admin accounts Username: Admin password: admin
		if (playerRepository.findByUsername("admin") == null) {

			System.out.println("CREATING ADMIN");
			PlayerModel admin = new PlayerModel();

			admin.setUsername("admin");
			admin.setEmail("economia@support.at");
			admin.setPassword("admin");
			admin.setRole("ADMIN");

			//System.out.println("SET UNITS");

			playerRepository.save(admin);
			// anlegen eines users für testzwecke
//			System.out.println("CREATING USER");
//			PlayerModel user = new PlayerModel();
//			user.setUsername("user");
//			user.setEmail("user@gmail.com");
//			user.setPassword("password");
//			user.setRole("USER");
//
//			playerRepository.save(user);

		}

		System.out.println("VALIDATION");

		// Validation eher schlecht als recht
		if (username.isEmpty() || email.isEmpty() || password.isEmpty() == true) {
			model.addAttribute("errorMessage", "Please fill up all fields");

			return "regFail";
		} else if (password.length() + 1 < 6 || password.length() + 1 > 30 || username.length() > 20
				|| email.length() > 70) {
			model.addAttribute("errorMessage", "Please uses a correct length for yor input");
			return "regFail";
		} else if (email.contains("@") == false) {
			model.addAttribute("errorMessage", "Please enter a valid email address");
			return "regFail";
		} else if (username.matches("^[a-zA-Z0-9]+$") == false) {
			model.addAttribute("errorMessage", "Please dont use special characters in your username");
			return "regFail";
		} else if (username == "admin") {
			model.addAttribute("errorMessage",
					"Your username \"admin\" is invalid. There already exists an Admin with that username. Nice try tho :^)");
			return "regFail";
		}

		System.out.println("SAVE USER");
		// überprüfen ob der Username schon vorhanden ist
		if (playerRepository.findByUsername(username) == null) {
			PlayerModel player = new PlayerModel();
			model.addAttribute("username", username);
			model.addAttribute("email", email);
			player.setUsername(username);
			player.setEmail(email);
			player.setPassword(password);
			player.setRole("USER");
			// player.setUnits();
			System.out.println(player.toString());
			playerRepository.save(player); // speichern in die db
			return "regSuccess";
		} else {
			System.out.println("failed");
			model.addAttribute("errorMessage", "The username is already taken.");
			return "regFail";
		}

	}

}