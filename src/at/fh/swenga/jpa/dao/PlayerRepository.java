
package at.fh.swenga.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import at.fh.swenga.jpa.model.PlayerModel;


@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<PlayerModel, String> {
	
	
//	@Modifying
//	@Query("select p from Player p where p.username = :username")
//	List<PlayerModel> findByUsernameGetList(@Param("username")String username);
	
	
//	String role="USER";
//	List<PlayerModel> findByUsernameAndRole(String username);
	
	//	List<PlayerModel> findByUsernameAndRole(String username);
	
	PlayerModel findByUsername(String username);
	
	List<PlayerModel> findAll();
	
	


}