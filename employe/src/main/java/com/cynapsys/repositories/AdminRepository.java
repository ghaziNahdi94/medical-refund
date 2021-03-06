package com.cynapsys.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cynapsys.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long>{
public List<Admin> findAll();
public List<Admin> findByCin(Long cin);
public Admin findByEmail(String email);
}
