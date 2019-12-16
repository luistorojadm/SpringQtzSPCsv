package com.jadm.springQtz.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadm.springQtz.Jobs.JobB;
import com.jadm.springQtz.config.AppConstants;
import com.jadm.springQtz.model.Gestor;
import com.jadm.springQtz.repository.GestorRepository;


@Service
public class ServiceA {
	
@Autowired
private GestorRepository gestorRepository;
	
    public static long IdGestor;
    
    private static final Logger LOG = LoggerFactory.getLogger(ServiceA.class);
	
	public long  GenerateIDGestor(Date fechaSolicitud) {
		
		Gestor gestor = new Gestor();
		gestor.setFechaSolicitud(fechaSolicitud);
		gestor.setEstado(AppConstants.ESTADO_PROCESO_GESTOR_1_NO_PROCESADO);
		this.gestorRepository.save(gestor);
		LOG.info("Creado por el servicioA" + gestor.getId());
		return  IdGestor =  gestor.getId();	
	}
}


