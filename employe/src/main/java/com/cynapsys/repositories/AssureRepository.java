package com.cynapsys.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.Admin;
import com.cynapsys.entities.Assure;


@Transactional
@Repository
public interface AssureRepository extends CrudRepository<Assure, Long>{

	public List<Assure> findByCin(Long cin);
	public List<Assure> findAll();
	public Assure getByCin(Long cin);
	public Assure getById(Long id);


	
}
