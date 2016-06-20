
package at.fh.swenga.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.jpa.model.BuildingModel;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.RecruitModel;


@Repository
@Transactional
public interface RecruitRepository extends JpaRepository<RecruitModel, String> {
	
	List<RecruitModel> findByPlayerUsername(String username);

	List<RecruitModel> findAll();

}