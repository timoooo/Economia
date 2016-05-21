package at.fh.swenga.jpa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.jpa.model.RobotModel;


@Repository
@Transactional
public interface RobotRepository extends JpaRepository<RobotModel, Integer> {

	public List<RobotModel> findByFirstName(String firstName);

	public List<RobotModel> findByLastName(String lastName);

	@Query("select r from RobotModel r where r.firstName = :name or r.lastName = :name")
	public List<RobotModel> findByAnything(@Param("name")String name);

	@Query("select r from RobotModel r where r.firstName like %?1")
	public List<RobotModel> findByFirstNameEndsWith(String firstName);
	
	@Query("select r from RobotModel r where r.lastName like %?1")
	public List<RobotModel> findByLastNameEndsWith(String lastName);
	
	List<RobotModel> findByOrderByLastNameAsc();
	
	List<RobotModel> findByOrderByFirstNameAsc();

	
	List<RobotModel> findTop10ByOrderByFirstNameAsc();
	
	List<RobotModel> findTop10ByOrderByLastNameAsc();
	
	@Query("select r from RobotModel r where r.firstName like %?1")
	public List<RobotModel> findBySomething(String something);
	
	







}
