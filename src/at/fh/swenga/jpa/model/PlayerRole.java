package at.fh.swenga.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playerroles")
public class PlayerRole implements java.io.Serializable {

	long version;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer playerRoleID;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private PlayerModel player;
	
	
	
	@Column(name = "role", nullable = false)
	private String role;

	public PlayerRole(PlayerModel player, String role) {
		super();
		this.player = player;
		this.role = role;
	}

	public PlayerRole() {
		super();
	}

	
	public Integer getPlayerRoleId() {
		return playerRoleID;
	}

	public void setPlayerRoleId(Integer playerRoleID) {
		this.playerRoleID = playerRoleID;
	}


	public PlayerModel getPlayer() {
		return player;
	}

	public void setUser(PlayerModel player) {
		this.player = player;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
