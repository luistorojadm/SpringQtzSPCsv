/**
 * 
 */
package com.jadm.springQtz.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jadm.springQtz.model.ApexArchExcl;

/**
 * @author ivega
 *
 */
public interface ApexArchExclRepository extends CrudRepository<ApexArchExcl, Long> {
	
	public List<ApexArchExcl> findAllBySessionNumber(Long sessionNumber);
	
	public Long deleteAllBySessionNumber(Long sessionNumber);

}// fin interface ApexArchExclRepository

