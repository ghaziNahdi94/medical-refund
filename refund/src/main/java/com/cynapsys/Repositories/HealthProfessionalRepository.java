package com.cynapsys.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.HealthProfessionnal;

@Transactional
@Repository
public interface HealthProfessionalRepository extends JpaRepository<HealthProfessionnal, Long>{

}
