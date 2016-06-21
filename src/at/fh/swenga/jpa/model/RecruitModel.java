package at.fh.swenga.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recruits")

// NamedQueries here

public class RecruitModel implements java.io.Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private int unitID = 0;

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
	private int attackPower = 0;

	@Column(nullable = false)
	private int deffPower = 0;

	@Column(nullable = false)
	private int accuracy = 0;

	@Column(nullable = false)
	private int speed = 0;
	
	@Column(nullable=false)
	private String size;
	

  
    @ManyToOne(optional=false)
    @JoinColumn(name="username",referencedColumnName="username") //links username ist Eintrag in dieser Table
    private PlayerModel player;
    /*
	@ManyToOne(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="playerName")
	private PlayerModel player;
	 */
    
    
	public RecruitModel(){}
	
	public RecruitModel(int unitID, String name, String icon, int count, int neededTicks, int neededWood, int neededStone, int neededFood, int neededGold,
			String neededBuilding, int attackPower, int deffPower, int accuracy, int speed) {
		super();
		this.unitID = unitID;
		this.icon = icon;
		this.name = name;
		this.count = count;
		this.neededTicks = neededTicks;
		this.neededWood = neededWood;
		this.neededStone = neededStone;
		this.neededFood = neededFood;
		this.neededGold = neededGold;
		this.neededBuilding = neededBuilding;
		this.attackPower = attackPower;
		this.deffPower = deffPower;
		this.accuracy = accuracy;
		this.speed = speed;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public int getDeffPower() {
		return deffPower;
	}

	public void setDeffPower(int deffPower) {
		this.deffPower = deffPower;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
//	
//	

	
	  public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}
	
		
		public int getUnitID() {
			return unitID;
		}

		public void setUnitID(int unitID) {
			this.unitID = unitID;
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
		return attackPower;
	}

	public void setPower(int power) {
		this.attackPower = power;
	}

	public int getCriticalHit() {
		return deffPower;
	}

	public void setCriticalHit(int criticalHit) {
		this.deffPower = criticalHit;
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