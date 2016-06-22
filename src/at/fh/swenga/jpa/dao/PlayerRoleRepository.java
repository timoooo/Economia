package at.fh.swenga.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.PlayerRole;

@Repository
@Transactional
public interface PlayerRoleRepository extends JpaRepository<PlayerRole, Integer> {


	List<PlayerRole> findByPlayerUsername(String username);
	
	List<PlayerRole> findByRole(String role);

}
