package com.cynapsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.AssuranceEmploye;


@Transactional
@Repository
public interface AssuranceEmployeRepository extends JpaRepository<AssuranceEmploye, Long>{
@Query ("select a from AssuranceEmploye a where a.idAssuranceUser= :x")
	AssuranceEmploye findOne(@Param("x") Long id);



	
	
}
