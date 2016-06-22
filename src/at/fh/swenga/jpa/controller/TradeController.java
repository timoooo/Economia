package at.fh.swenga.jpa.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import at.fh.swenga.jpa.dao.HistoryRepository;
import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.dao.TradeRepository;
import at.fh.swenga.jpa.model.HistoryModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.TradeModel;



@Controller
public class TradeController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	TradeRepository tradeRepository;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@RequestMapping(value = "/trade", method = RequestMethod.GET)
	  public String handleTrade(Model model, Principal principal ) {
		 
	      String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("player", player);
	      //model.addAttribute("date", LocalDateTime.now());
	      model.addAttribute("offers", tradeRepository.findAll());
	      model.addAttribute("myOffers", tradeRepository.findByPlayerUsername(name));
	     
		return "trade";
	}
	
	@RequestMapping(value = "/tradeFeedback", method = RequestMethod.POST)
	@Transactional
	  public String handleTradeFeedback(Model model, Principal principal) {;
		  String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("player", player);
	     
		return "tradeFeedback";
	}
	
	@RequestMapping(value = "/tradeDelete", method = RequestMethod.GET)
	  public String handleTradeDelete(Model model, Principal principal, @RequestParam int id) {;
		  String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	      model.addAttribute("player", player);
	      
	      TradeModel trade = tradeRepository.findById(id);
	      if(trade.getPlayer().getUsername().equals(principal.getName())!= true)
		  {
		      model.addAttribute("errorMessage","You cant delete an offer from another user");
				return "forward:/trade";
		  }
	      
	      //reset resources
	      player.setFood(player.getFood()+trade.getFood());
	      player.setStone(player.getStone()+trade.getStone());
	      player.setWood(player.getWood()+trade.getWood());
	      
	      playerRepository.save(player);
	      	      
	      
	      tradeRepository.removeById(id);
	      model.addAttribute("warningMessage","You deleted your offer with id " + id);
	     
		return "forward:/trade";
	}
	
	@RequestMapping(value = "/tradeBuy", method = RequestMethod.GET)
	  public String handleTradeBuy(Model model, Principal principal, @RequestParam int id) {;
		  String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	      
	      model.addAttribute("player", player);
	      
	      TradeModel trade = tradeRepository.findById(id);
	      PlayerModel seller = playerRepository.findByUsername(trade.getPlayer().getUsername());
	      
	      //Set the current player values
	      int goldLeft = player.getGold()-trade.getPrice();
	      if (goldLeft<0){
		      model.addAttribute("errorMessage","Not enough gold my lord");
				return "forward:/trade";
	      }
	      player.setGold(goldLeft);
	      player.setFood(player.getFood()+trade.getFood());
	      player.setStone(player.getStone()+trade.getStone());
	      player.setWood(player.getWood()+trade.getWood());
	      
	      playerRepository.save(player);
	      
	      
	      //Set the Seller values
	      seller.setGold(seller.getGold()+trade.getPrice());
	      playerRepository.save(seller);
	      
	      
	      
	      //delete the offer
	      tradeRepository.removeById(id);
	      
	      
	      
	      model.addAttribute("message","You buyed resources");
	      System.out.print("TRADEBUY");
	     
		return "forward:/trade";
	}
	
	
	
	@RequestMapping(value = "/trade", method = RequestMethod.POST)
	@Transactional
	public String newOffer(@Valid @ModelAttribute TradeModel newOffer, BindingResult bindingResult,
			Model model, Principal principal ) {			//@RequestParam int addUnit1,
		//@RequestParam int addUnit2, @RequestParam int addUnit3, @RequestParam int addUnit4
 
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);
			return "forward:/tradeFeedback";
		}
		
		if (newOffer.getPlayer().getUsername().equals(principal.getName()) != true) {
			model.addAttribute("errorMessage", "Wrong UserId submitted");

			System.out.println("Wrong UserID: " + newOffer.getPlayer().getUsername() + " And not: " + principal.getName());
			return "forward:/tradeFeedback";
		}
		
		  String name = principal.getName(); //get logged in username
	      PlayerModel player = playerRepository.findByUsername(name);
	
	      
	      String errorMessage = checkAndSaveSellerValues(newOffer, player);
	      if(errorMessage!=null){
	    	  model.addAttribute("errorMessage", errorMessage);
	    	  return "forward:/tradeFeedback";
	      }
			
		
		//Offer in db speichern
		saveOffer(newOffer);
		model.addAttribute("message","New Offer published");
 
		return "forward:/tradeFeedback";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@Transactional
	private void saveOffer(TradeModel newOffer){
		TradeModel offer = new TradeModel();
		offer.setPlayer(getPlayerModel(newOffer.getPlayer().getUsername()));
		offer.setWood(newOffer.getWood());
		offer.setStone(newOffer.getStone());
		offer.setFood(newOffer.getFood());
		offer.setPrice(newOffer.getPrice());
		
		PlayerModel player = offer.getPlayer();
		player.addTradeOffer(offer);
		player = addHistoryEntry(player,"You made a new offer for "+ newOffer.getPrice() +" gold!","trade");
		
		playerRepository.save(player);
		tradeRepository.save(offer);
		

		
		
		System.out.println("Saved trade");
	}
	
	@Transactional		//return null and save Seller if no error, otherwise return errorMessage
	private String checkAndSaveSellerValues(TradeModel newOffer, PlayerModel player){
		String errorMessage = null;
		int foodLeft = player.getFood()-newOffer.getFood();
		int stoneLeft = player.getStone()-newOffer.getStone();
		int woodLeft = player.getWood()-newOffer.getWood();
		
		if(foodLeft<0){
			return "You don't own enough Food Sire";
		}
		if (stoneLeft<0){
			return "You don't own enough Stone Sire";
		}
		if (woodLeft<0){		//falls 
			return "You don't not own enough Wood Sire";
		}
		
	    player.setFood(foodLeft);
	    player.setStone(stoneLeft);
	    player.setWood(woodLeft);
	    playerRepository.save(player);
	    return null;
	}
	
	private PlayerModel getPlayerModel(String string){
		return playerRepository.findByUsername(string);
	}
	
	private PlayerModel addHistoryEntry (PlayerModel player, String message, String type){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df; 
        df = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");     // 31.01.2016 20:07
		
		HistoryModel history = new HistoryModel(); 
		history.setPlayer(player);
		history.setInfo(message);
		history.setType(type);
		history.setDate(now.format(df));
		//Date date
		player.addHistory(history);
		historyRepository.save(history);
		return player;
	}
	
}


