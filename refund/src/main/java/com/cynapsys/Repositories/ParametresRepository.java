package com.cynapsys.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.controllers.Parametres;

@Transactional
@Repository
public interface ParametresRepository extends CrudRepository<Parametres, Long>{

	public Parametres findById(int id);
	
}
