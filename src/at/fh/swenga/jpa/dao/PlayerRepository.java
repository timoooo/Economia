package at.fh.swenga.jpa.dao;

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

	PlayerModel findByUsername(String username);
	
	


}
