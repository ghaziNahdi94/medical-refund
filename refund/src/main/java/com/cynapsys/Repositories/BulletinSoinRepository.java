package com.cynapsys.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.BulletinSoin;

@Repository
@Transactional
public interface BulletinSoinRepository extends JpaRepository<BulletinSoin, Long>{

	

	
}
