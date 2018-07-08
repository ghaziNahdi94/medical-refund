package com.cynapsys.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.ArticleMedical;

@Transactional
@Repository
public interface ArticleMedicalRepositories extends JpaRepository<ArticleMedical, Long> {

	
	
}
