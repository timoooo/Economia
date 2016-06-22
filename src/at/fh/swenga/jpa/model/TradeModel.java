package at.fh.swenga.jpa.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "trade")


public class TradeModel implements java.io.Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@Column(nullable = false)
	private int price = 0;		//newBuilding -> b | newRecruits -> r | newFight -> f | newTrade -> t|
	
    @Column(nullable = false,  length = 60)
    private int wood = 0;  	//buldingIdName | TroopName | FightEnemyName | TradePlayerName		
    
    @Column(nullable = false)
    private int stone = 0;	
    
    @Column(nullable = false)
    private int food = 0;	
    
	//@NotNull(message = "{0} is required")
	//@DateTimeFormat(pattern = "kk.mm dd.MM.yyyy")
	//private LocalDateTime date;
		
    
    @ManyToOne(optional=false)
    @JoinColumn(name="username",referencedColumnName="username")
    private PlayerModel player;
    

	public TradeModel() {
	}

	public TradeModel(int wood, int stone, int food, int price) {
		super();
		this.price = price;
		this.wood = wood;
		this.stone = stone;
		this.food = food;
		
		//DateTimeFormatter  df = DateTimeFormatter.ofPattern("k.mm <br> dd.MM.yyyy");
		//this.date = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getStone() {
		return stone;
	}

	public void setStone(int stone) {
		this.stone = stone;
	}

	
//	public LocalDateTime getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}

	
	
    
}

