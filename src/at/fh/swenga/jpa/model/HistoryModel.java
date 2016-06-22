package at.fh.swenga.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "history")
@Transactional
public class HistoryModel implements java.io.Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 70)
	String type;

	@Column(nullable = false, length = 1000)
	String info;

	@NotNull(message = "{0} is required")
	private String date;
    
	
    @ManyToOne(optional=false)
    @JoinColumn(name="username",referencedColumnName="username")
    private PlayerModel player;
   
	
	
    @Version
	long version;

    public HistoryModel() {
	}


	public HistoryModel(int id, String type, String info, String date) {
		super();
		this.id = id;
		this.type = type;
		this.info = info;
		this.date = date;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String string) {
		this.date = string;
	}



	public PlayerModel getPlayer() {
		return player;
	}



	public void setPlayer(PlayerModel player) {
		this.player = player;
	}


	

	
    
    

}
