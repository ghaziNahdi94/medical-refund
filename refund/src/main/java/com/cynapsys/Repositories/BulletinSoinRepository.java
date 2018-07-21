package com.cynapsys.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.BulletinSoin;

@Repository
@Transactional
public interface BulletinSoinRepository extends CrudRepository<BulletinSoin, Long>{

	public BulletinSoin getById(Long id);
	public List<BulletinSoin> findAll();
	public List<BulletinSoin> findByBordereauId(Long bordereauId);
	public List<BulletinSoin> findByAssureId(Long id);
	
}
