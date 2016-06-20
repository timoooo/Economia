package at.fh.swenga.jpa.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recruit")

// NamedQueries here

public class RecruitModel implements java.io.Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 30)
	private String name = "Bauhaus";
	
	@Column(nullable = false)
	private String icon;
	
	@Column(nullable = false)
	private int count = 1;
	
	@Column(nullable = false)
	private int neededTicks = 0;

	@Column(nullable = false)
	private int neededWood = 0;

	@Column(nullable = false)
	private int neededStone = 0;

	@Column(nullable = false)
	private int neededFood = 0;

	@Column(nullable = false)
	private int neededGold = 0;
	
	@Column(nullable = false)
	private String neededBuilding = "Barack";

	@Column(nullable = false)
	private int power = 0;

	@Column(nullable = false)
	private int criticalHit = 0;

	@Column(nullable = false)
	private int accuracy = 0;

	@Column(nullable = false)
	private int speed = 0;

	
    @ManyToOne(optional=false)
    @JoinColumn(name="username",referencedColumnName="username") //links username ist Eintrag in dieser Table
    private PlayerModel player;
   
	
    /*
	@ManyToOne(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="playerName")
	private PlayerModel player;
	 */
    
    
	public RecruitModel(){}
	
	public RecruitModel(String name, String icon, int count, int neededTicks, int neededWood, int neededStone, int neededFood, int neededGold,
			String neededBuilding, int power, int criticalHit, int accuracy, int speed) {
		super();
		this.icon = icon;
		this.name = name;
		this.count = count;
		this.neededTicks = neededTicks;
		this.neededWood = neededWood;
		this.neededStone = neededStone;
		this.neededFood = neededFood;
		this.neededGold = neededGold;
		this.neededBuilding = neededBuilding;
		this.power = power;
		this.criticalHit = criticalHit;
		this.accuracy = accuracy;
		this.speed = speed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public void addCount(int number) {
		this.count += number;
	}
	
	public void remCount(int number) {
		this.count -= number;
	}
	
	public int getCount() {
		return this.count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNeededTicks() {
		return neededTicks;
	}

	public void setNeededTicks(int neededTicks) {
		this.neededTicks = neededTicks;
	}

	public int getNeededWood() {
		return neededWood;
	}

	public void setNeededWood(int neededWood) {
		this.neededWood = neededWood;
	}

	public int getNeededStone() {
		return neededStone;
	}

	public void setNeededStone(int neededStone) {
		this.neededStone = neededStone;
	}

	public int getNeededFood() {
		return neededFood;
	}

	public void setNeededFood(int neededFood) {
		this.neededFood = neededFood;
	}

	public int getNeededGold() {
		return neededGold;
	}

	public void setNeededGold(int neededGold) {
		this.neededGold = neededGold;
	}

	public String getNeededBuilding() {
		return neededBuilding;
	}

	public void setNeededBuilding(String neededBuilding) {
		this.neededBuilding = neededBuilding;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCriticalHit() {
		return criticalHit;
	}

	public void setCriticalHit(int criticalHit) {
		this.criticalHit = criticalHit;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}

}
