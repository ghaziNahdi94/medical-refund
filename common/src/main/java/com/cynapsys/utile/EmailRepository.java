package com.cynapsys.utile;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface EmailRepository extends CrudRepository<Email, Long>{

}
