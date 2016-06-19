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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.metamodel.StaticMetamodel;

@Entity
@Table(name = "Ressourse")

//NamedQueries here
/*
@NamedQueries (
		{
			@NamedQuery(
					name="RessourseModel.findByDoALike",
					query="select e from BuildingModel e where e.firstName like :name or e.lastName like :name")
		}

		)

*
public class User {
    @OneToOne(mappedBy = "user")
    private Status status;
    // ...
}

public class Status {
    @OneToOne
    @JoinColumn(name = "frn_user_id")
    private User user;
    // ...
}
*
*/



public class ResourceModel implements java.io.Serializable{
	@Id
	@OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "username")
    private PlayerModel player;
	

    
    @Column(nullable = false)
    int wood = 0;
    
    @Column(nullable = false)
    int stone = 0;
    
    @Column(nullable = false)
    int food = 0;
    
    @Column(nullable = false)
    int gold = 0;
    
    @Column(nullable = false)
    int militaryUnits = 0;
    
	@Version
	long version;

	public ResourceModel() {
	}
 
	public ResourceModel(PlayerModel player, int wood, int stone, int food, int gold, int militaryUnits) {
		super();
		this.player = player;
		this.wood = wood;
		this.stone = stone;
		this.food = food;
		this.gold = gold;
		this.militaryUnits = militaryUnits;
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


	public PlayerModel getPlayer() {
		return player;
	}


	public void setPlayer(PlayerModel player) {
		this.player = player;
	}
	
	


	
    
}
