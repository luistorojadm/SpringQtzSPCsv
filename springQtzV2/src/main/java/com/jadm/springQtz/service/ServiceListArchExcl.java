package com.jadm.springQtz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadm.springQtz.model.ApexArchExcl;
import com.jadm.springQtz.repository.ApexArchExclRepository;

@Service
public class ServiceListArchExcl {
	
	@Autowired
    private ApexArchExclRepository apexArchExclRepository ;
		
	    public ArrayList listAll() {

        return (ArrayList<ApexArchExcl>) apexArchExclRepository.findAll();
    } // fin List listAll()
}
