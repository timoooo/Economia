
package at.fh.swenga.jpa.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.jpa.model.ActionModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.TradeModel;

@Repository
@Transactional
public interface TradeRepository extends JpaRepository<TradeModel, String> {

	List<TradeModel> findByPlayerUsername(String username);
	
	void removeById(int index);

	TradeModel findById(int id);
	

}