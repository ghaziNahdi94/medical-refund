package com.cynapsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.AssuranceEmploye;


@Transactional
@Repository
public interface AssuranceEmployeRepository extends JpaRepository<AssuranceEmploye, Long>{

	/**/
	
}
