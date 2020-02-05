package com.jadm.springQtz.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadm.springQtz.config.AppConstants;
import com.jadm.springQtz.model.Gestor;
import com.jadm.springQtz.repository.GestorRepository;


@Service
public class ServiceGestorAppex {
	
@Autowired
private GestorRepository gestorRepository;
	
    private static final Logger LOG = LoggerFactory.getLogger(ServiceGestorAppex.class);

	public long  GenerateIDGestor(Date fechaSolicitud) {
		
		long IdGestor=0L;
		
		Gestor gestor = new Gestor();
		gestor.setFechaSolicitud(fechaSolicitud);
		gestor.setEstado(AppConstants.ESTADO_PROCESO_GESTOR_2_EN_PROCESO);
		gestor.setCodigoAccion(AppConstants.ACCION_MODULO_DESCARGA);
		try {
		this.gestorRepository.save(gestor);
		}catch(Exception e) {
			e.printStackTrace();
            LOG.error("No se logro persistir en BD nuevo id gestor:",e);
		}
		LOG.info("Creado por el servicioA" + gestor.getId());
		IdGestor =  gestor.getId();
		return  IdGestor;	
	}
	
	public boolean  updateGestor(Long Id, String nameCsv, String ruta_archivo) {
		Date fechaFinProceso = new java.sql.Date(new java.util.Date().getTime());
		Optional<Gestor> gestorById = null;
		boolean statusProceso=true;
		LOG.info("Obtiene por Constructor para UpdateGestorr :" + Id);
		try {
			gestorById = gestorRepository.findById(Id);
		}catch (Exception e) {
			statusProceso=false;
			e.printStackTrace();
            LOG.error("No se encontro el registro del gestor id:'{}'", Id,e);
		}
		if (statusProceso ==true) {
			Gestor gestor = gestorById.get();
			gestor.setFechaFinProceso(fechaFinProceso);
			gestor.setEstado(AppConstants.ESTADO_PROCESO_GESTOR_4_TERMINADO_OK);
			gestor.setNombreArchivo(nameCsv);
			gestor.setRutaArchivo(ruta_archivo);
			try {
			this.gestorRepository.save(gestor);
			LOG.info("Actualizacion Completada: " + Id);
			}catch (Exception e) {
				statusProceso=false;
				e.printStackTrace();
	            LOG.error("No se logro persistir en BD el gestor id:'{}'", Id,e);
			}
		}
		return statusProceso;
	}
	
		public boolean  updateGestorNoOk(Long Id) {
			Date fechaFinProceso = new java.sql.Date(new java.util.Date().getTime());
			Optional<Gestor> gestorById = null;
			boolean statusProceso=true;
			LOG.info("Obtiene por Constructor para UpdateGestorr :" + Id);
			try {
				gestorById = gestorRepository.findById(Id);
			}catch (Exception e) {
				statusProceso=false;
				e.printStackTrace();
	            LOG.error("No se encontro el registro del gestor id:'{}'", Id,e);
			}
			if (statusProceso ==true) {
				Gestor gestor = gestorById.get();
				gestor.setFechaFinProceso(fechaFinProceso);
				gestor.setEstado(AppConstants.ESTADO_PROCESO_GESTOR_3_TERMINADO_NOK);
				gestor.setNombreArchivo("");
				gestor.setRutaArchivo("");
				try {
				this.gestorRepository.save(gestor);
				LOG.info("Actualizacion Completada: " + Id);
				}catch (Exception e) {
					statusProceso=false;
					e.printStackTrace();
		            LOG.error("No se logro persistir en BD el gestor id:'{}'", Id,e);
				}
			}
			return statusProceso;
	}
}


