package com.cynapsys.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.Bordereau;

@Transactional
@Repository
public interface BordereauRepository extends CrudRepository<Bordereau, Long> {

	public List<Bordereau> findAll();
	
}
