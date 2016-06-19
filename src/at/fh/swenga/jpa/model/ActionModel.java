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

@Entity
@Table(name = "Action")

//NamedQueries here
/*
@NamedQueries (
		{
			@NamedQuery(
					name="RessourseModel.findByDoALike",
					query="select e from BuildingModel e where e.firstName like :name or e.lastName like :name")
		}

		)
*/

public class ActionModel implements java.io.Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@Column(nullable = false)
	char type = 'b';		//newBuilding -> b | newTroops -> t | newFight -> f | newTrade -> |
	
    @Column(nullable = false,  length = 60)
    String typePropertyName = "";  	//buldingIdName | TroopIdName | FightEnemyName | TradePlayerName		
    
    @Column(nullable = false)
    int ticksLeft = -1;		
		
    @Column(nullable = false,  length = 420)
    String additionalInfo = "";
    
	@ManyToOne(cascade = CascadeType.PERSIST)
	PlayerModel player;
    
	@Version
	long version;
	
	public ActionModel() {
	}

	public ActionModel(char type, String typePropertyName, int ticksLeft, String additionalInfo) {
		super();
		this.type = type;
		this.typePropertyName = typePropertyName;
		this.ticksLeft = ticksLeft;
		this.additionalInfo = additionalInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getTypePropertyName() {
		return typePropertyName;
	}

	public void setTypePropertyName(String typePropertyName) {
		this.typePropertyName = typePropertyName;
	}

	public int getTicksLeft() {
		return ticksLeft;
	}

	public void setTicksLeft(int ticksLeft) {
		this.ticksLeft = ticksLeft;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}  	
	
    
}

