package at.fh.swenga.jpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Robot")

// NamedQueries here

@NamedQueries (
		{
			@NamedQuery(
					name="RobotModel.findByDoALike",
					query="select e from RobotModel e where e.firstName like :name or e.lastName like :name")
		}

		)

public class RobotModel implements java.io.Serializable {


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 30)
	String firstName;

	@Column(nullable = false, length = 30)
	String lastName;

	@Column(nullable = false, length = 30)
	String nickName;

	// Date Only, no time part:
	@Temporal(TemporalType.DATE)
	Date dayOfBirth;


	@ManyToOne (cascade = CascadeType.PERSIST)
	CompanyModel company;


	public RobotModel() {
	}






	public RobotModel(String firstName, String lastName, String nickName, Date dayOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.dayOfBirth = dayOfBirth;
	}



	public String getNickName() {
		return nickName;
	}




	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}


	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company=company;
	}


}
