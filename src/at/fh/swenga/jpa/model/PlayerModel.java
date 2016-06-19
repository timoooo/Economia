package at.fh.swenga.jpa.model;

import java.util.HashSet;
import java.util.Set;

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

import org.springframework.data.annotation.Persistent;

@Entity
@Table(name = "Player")

public class PlayerModel implements java.io.Serializable {

	@Id
	@Column(name = "username")
	private String username;

	@Column(nullable = false, length = 70)
	String email;

	@Column(nullable = false, length = 30)
	String password;

	@Column(nullable = false, length = 10)
	String role;
	


	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
	@OrderBy("id")
	private Set<BuildingModel> buildings;

	@OneToOne(mappedBy = "player")
	private ResourceModel resources;
	
	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
	@OrderBy("id")
	private Set<ActionModel> actions;


	@Version
	long version;

	public PlayerModel() {
	}

	public PlayerModel(String username, String email, String password, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public ResourceModel getResources() {
		return resources;
	}
	
	public void setResources(ResourceModel resources){
		this.resources = resources;
	}
	
	public Set<ActionModel> getActions() {
		return actions;
	}
																	//fehlt die remove funktion!!!!
	public void setActions(Set<ActionModel> actions) {
		this.actions = actions;
	}

	public void addAction(ActionModel action) {
		if (actions == null) {
			actions = new HashSet<ActionModel>();
		}
		actions.add(action);
	}


	public Set<BuildingModel> getBuildings() {
		return buildings;
	}

	public void setBuildings(Set<BuildingModel> buildings) {
		this.buildings = buildings;
	}

	public void addBuilding(BuildingModel building) {
		if (buildings == null) {
			buildings = new HashSet<BuildingModel>();
		}
		buildings.add(building);
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {


	return "User [name=" + username + ", email=" + email + ", passwd=" + password + ", role="+role + ", wood " + resources.wood + " ]";


	}

}