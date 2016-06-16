package at.fh.swenga.jpa.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/*
@Entity
@Table(name = "Villages")
public class Villages implements java.io.Serializable {
	
	@Id
	@Column(name = "name")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int name;
	
	@OneToMany(mappedBy="buildings",fetch=FetchType.LAZY)
    @OrderBy("name")
    private List<Buildings> buildings;
	
	/*
	@OneToMany (cascade = CascadeType.PERSIST)
	Buildings buildings2;
*/
/*
	
	public Villages(int name, List<Buildings> buildings) {
		super();
		this.name = name;
		this.buildings = buildings;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public List<Buildings> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Buildings> buildings) {
		this.buildings = buildings;
	}

	
	
}
*/