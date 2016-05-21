package at.fh.swenga.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.jpa.model.CompanyModel;

@Repository

public interface CompanyRepository extends JpaRepository<CompanyModel, Integer> {

	@Transactional
	public CompanyModel findFirstByName(String name);

}
