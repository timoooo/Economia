package at.fh.swenga.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Building")

// NamedQueries here

public class BuildingModel implements java.io.Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 30)
	String name = "Bauhaus";
	
	@Column(nullable = false)
	int neededTicks = 0;

	@Column(nullable = false)
	int neededWood = 0;

	@Column(nullable = false)
	int neededStone = 0;

	@Column(nullable = false)
	int neededFood = 0;

	@Column(nullable = false)
	int neededGold = 0;

	@Column(nullable = false)
	int woodOutput = 0;

	@Column(nullable = false)
	int stoneOutput = 0;

	@Column(nullable = false)
	int foodOutput = 0;

	@Column(nullable = false)
	int goldOutput = 0;

	@ManyToOne(cascade = CascadeType.PERSIST)
	PlayerModel player;
	
	public BuildingModel(){}
	
	public BuildingModel(String name, int neededTicks ,int neededWood, int neededStone, int neededFood, int neededGold,
			int woodOutput, int stoneOutput, int foodOutput, int goldOutput) {
		super();
		this.name = name;
		this.neededTicks = neededTicks;
		this.neededWood = neededWood;
		this.neededStone = neededStone;
		this.neededFood = neededFood;
		this.neededGold = neededGold;
		this.woodOutput = woodOutput;
		this.stoneOutput = stoneOutput;
		this.foodOutput = foodOutput;
		this.goldOutput = goldOutput;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getWoodOutput() {
		return woodOutput;
	}

	public void setWoodOutput(int woodOutput) {
		this.woodOutput = woodOutput;
	}

	public int getStoneOutput() {
		return stoneOutput;
	}

	public void setStoneOutput(int stoneOutput) {
		this.stoneOutput = stoneOutput;
	}

	public int getFoodOutput() {
		return foodOutput;
	}

	public void setFoodOutput(int foodOutput) {
		this.foodOutput = foodOutput;
	}

	public int getGoldOutput() {
		return goldOutput;
	}

	public void setGoldOutput(int goldOutput) {
		this.goldOutput = goldOutput;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}

}
