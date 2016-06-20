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
	private char type = 'b';		//newBuilding -> b | newRecruits -> r | newFight -> f | newTrade -> t|
	
    @Column(nullable = false,  length = 60)
    private String target = "";  	//buldingIdName | TroopName | FightEnemyName | TradePlayerName		
    
    @Column(nullable = false)
    private int ticksLeft = -1;		
		
    @Column(nullable = false,  length = 420)
    private String additionalInfo = "";
    
	@ManyToOne(cascade = CascadeType.PERSIST)
	private PlayerModel player;
    
	@Version
	private long version;
	
	public ActionModel() {
	}

	public ActionModel(char type, String target, int ticksLeft, String additionalInfo) {
		super();
		this.type = type;
		this.target = target;
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

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
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

