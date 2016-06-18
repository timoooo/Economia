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
@Table(name = "Player" )


public class PlayerModel implements java.io.Serializable {

	@Id
	@Column(name = "username")
	private String username;

	
	
	@Column(nullable = false, length = 70)
	String email;

	@Column(nullable = false, length = 30)
	String password;

	
	
	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
	@OrderBy("name")
	private Set<BuildingModel> buildings;

	@OneToOne(mappedBy = "player", fetch = FetchType.LAZY)
	@OrderBy("name")
	private RessourseModel ressourseModel;

	@Version
	long version;

	public PlayerModel() {
	}

	public PlayerModel(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {

		return "User [name=" + username + ", email=" + email + ", passwd=" + password+"]";

	}

}
