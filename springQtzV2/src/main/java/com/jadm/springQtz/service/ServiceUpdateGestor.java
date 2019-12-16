package com.jadm.springQtz.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadm.springQtz.Jobs.JobB;
import com.jadm.springQtz.config.AppConstants;
import com.jadm.springQtz.model.Gestor;
import com.jadm.springQtz.repository.GestorRepository;

@Service
public class ServiceUpdateGestor {
	
	@Autowired
	private GestorRepository gestorRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(ServiceUpdateGestor.class);
	
	public void  updateGestor(Long Id, Date fechaFinProceso, String nameCsv) {
		
		LOG.info("Obtiene por Constructor para UpdateGestorr :" + Id);
		Optional<Gestor> gestorById = gestorRepository.findById(Id);		
		Gestor gestor = gestorById.get();
		gestor.setFechaFinProceso(fechaFinProceso);
		gestor.setEstado(AppConstants.ESTADO_PROCESO_GESTOR_4_TERMINADO_OK);
		gestor.setRutaArchivo(nameCsv);
		this.gestorRepository.save(gestor);
		LOG.info("Actualizacion Completada: " + Id);
	}

}
