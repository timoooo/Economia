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
@Table(name = "building")

// NamedQueries here

public class BuildingModel implements java.io.Serializable, Cloneable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String icon;
	
	@Column(nullable = false, length = 30)
	private String name = "Bauhaus";
	
	@Column(nullable = false)
	private int ticksuntilReady = 5;

	@Column(nullable = false)
	private int neededWood = 20;

	@Column(nullable = false)
	private int neededStone = 10;

	@Column(nullable = false)
	private int neededFood = 5;

	@Column(nullable = false)
	private int neededGold = 1;
	
	@Column(nullable = false)
	private int level = 1;


	@Column(nullable = false)
	private int woodOutput = 30;

	@Column(nullable = false)
	private int stoneOutput = 20;

	@Column(nullable = false)
	private int foodOutput = 2;

	@Column(nullable = false)
	private int goldOutput = 0;

	
    @ManyToOne(optional=false)
    @JoinColumn(name="username",referencedColumnName="username")
    private PlayerModel player;
   
	
    /*
	@ManyToOne(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="playerName")
	private PlayerModel player;
	 */
    
    
	public BuildingModel(){}
	
	public BuildingModel(String name, String icon, int ticksuntilReady ,int neededWood, int neededStone, int neededFood, int neededGold,
			int woodOutput, int stoneOutput, int foodOutput, int goldOutput) {
		super();
		this.name = name;
		this.icon = icon;
		this.ticksuntilReady = ticksuntilReady;
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
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTicksuntilReady() {
		return ticksuntilReady;
	}

	public void setTicksuntilReady(int ticksuntilReady) {
		this.ticksuntilReady = ticksuntilReady;
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
	
	public void levelUp(){
		this.level +=1;
	}
	
	public int getLevel(){
		return this.level;
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

	public BuildingModel clone() {

		BuildingModel obj = new BuildingModel();
        
		obj.setName(this.name);
		obj.setIcon (this.icon);
		obj.setTicksuntilReady (this.ticksuntilReady);
		obj.setNeededWood (this.neededWood);
		obj.setNeededStone (this.neededStone);
		obj.setNeededFood (this.neededFood);
		obj.setNeededGold (this.neededGold);
		obj.setWoodOutput (this.woodOutput);
		obj.setStoneOutput (this.stoneOutput);
		obj.setFoodOutput (this.foodOutput);
		obj.setGoldOutput (this.goldOutput);
        return obj;
    }
	
}
