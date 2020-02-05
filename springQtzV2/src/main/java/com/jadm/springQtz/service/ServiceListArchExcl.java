package com.jadm.springQtz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.jadm.springQtz.model.ApexArchExcl;
import com.jadm.springQtz.repository.ApexArchExclRepository;

@Service
@Transactional
public class ServiceListArchExcl {
	
	@Autowired
    private ApexArchExclRepository apexArchExclRepository ;
		
	    public ArrayList listAll() {

        return (ArrayList<ApexArchExcl>) apexArchExclRepository.findAll();
	    }// fin List listAll()
        
        public ArrayList listBySessionNumber(Long sessionNumber) {

            return (ArrayList) apexArchExclRepository.findAllBySessionNumber(sessionNumber);
        } // fin List<MapeoPixTW> findAllBysessionNumber(Long sessionNumber)
        
        public Long deleteAllBySession(Long sessionNumber) {

            return apexArchExclRepository.deleteAllBySessionNumber(sessionNumber);
        } // fin Long deleteAllbySession(Long sessionNumber)
} 
