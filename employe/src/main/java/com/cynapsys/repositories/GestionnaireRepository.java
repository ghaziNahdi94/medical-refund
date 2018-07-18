package com.cynapsys.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.Gestionnaire;
@Transactional
public interface GestionnaireRepository extends CrudRepository<Gestionnaire, Long> {
	public List<Gestionnaire> findByCin(Long cin);
	public List<Gestionnaire> findAll();
}
