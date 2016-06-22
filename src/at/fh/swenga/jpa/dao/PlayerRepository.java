
package at.fh.swenga.jpa.dao;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.jpa.model.PlayerModel;


@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<PlayerModel, String> {
	
	
	List<PlayerModel> findByDeffPowerUnitsBetween(int deffPowerSmaller, int deffPowerGreater);
	
	//List<PlayerModel> findByDeffPowerUnits(int deff);
	
	
	PlayerModel findByUsername(String username);
	
	List<PlayerModel> findAll();
	
	


}