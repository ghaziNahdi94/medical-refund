package com.cynapsys.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.Assure;


@Transactional
@Repository
public interface AssureRepository extends JpaRepository<Assure, Long>{

	 @Query ("select a from Assure a where a.id= :x")
	 public	Assure findOne(@Param("x") Long id);
	@Query("select c from Assure c where c.nom like :x")
	public List<Assure> chercher(@Param("x") String motcle);




	
	
}
