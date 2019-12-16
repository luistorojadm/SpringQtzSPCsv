package com.jadm.springQtz.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jadm.springQtz.model.Gestor;

@Repository
public interface GestorRepository extends CrudRepository<Gestor, Long> {

} // fin interface GestorRepository
