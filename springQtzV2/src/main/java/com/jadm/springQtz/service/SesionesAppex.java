package com.jadm.springQtz.service;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
@Service
public class SesionesAppex {
	
	@Autowired
	private EntityManager entityManager;
	
	public BigDecimal getNextSesionId() {
		
		//BigDecimal SesionId = new BigDecimal("5732"); //Solo Para Pruebas sin SP
		
		BigDecimal SesionId = (BigDecimal) entityManager.createNativeQuery("SELECT APP_SAM.SESIONES_APPEX.NEXTVAL FROM DUAL").getSingleResult();
		
		return SesionId;	
	}
}
