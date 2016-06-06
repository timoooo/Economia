package at.fh.swenga.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Ressourse")
public class RessourseModel implements java.io.Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(nullable = false, length = 30)
    int wood = 0;
    
    @Column(nullable = false, length = 30)
    int stone = 0;
    
    @Column(nullable = false, length = 30)
    int food = 0;
    
    @Column(nullable = false, length = 30)
    int gold = 0;
    
    @Column(nullable = false, length = 30)
    int militaryUnits = 0;

    
 
	@Version
	long version;
    
    
    public RessourseModel() {
		
    }


	public RessourseModel(int id, int wood, int stone, int food, int gold, int militaryUnits) {
		super();
		this.id = id;
		this.wood = wood;
		this.stone = stone;
		this.food = food;
		this.gold = gold;
		this.militaryUnits = militaryUnits;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getFood() {
		return food;
	}


	public void setFood(int food) {
		this.food = food;
	}


	public int getGold() {
		return gold;
	}


	public void setGold(int gold) {
		this.gold = gold;
	}


	public int getMilitaryUnits() {
		return militaryUnits;
	}


	public void setMilitaryUnits(int militaryUnits) {
		this.militaryUnits = militaryUnits;
	}
    

	
    
}
