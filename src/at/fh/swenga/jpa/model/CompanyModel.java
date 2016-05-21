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
import javax.persistence.OrderBy;
import javax.persistence.Version;

@Entity
public class CompanyModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
    @OneToMany(mappedBy="company",fetch=FetchType.LAZY)
    @OrderBy("lastName, firstName")
    private Set<RobotModel> robots;

	@Version
	long version;
    
    
    public CompanyModel() {
		// TODO Auto-generated constructor stub
    }
    
	public CompanyModel(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RobotModel> getRobots() {
		return robots;
	}

	public void setRobots(Set<RobotModel> robots) {
		this.robots = robots;
	}
	
	public void addRobot(RobotModel robot) {
		if (robots==null) {
			robots= new HashSet<RobotModel>();
		}
		robots.add(robot);
	}
	
    
}
