package com.jadm.springQtz.Jobs;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jadm.springQtz.service.ServiceGestorAppex;
import com.jadm.springQtz.service.ServiceListArchExcl;
import com.jadm.springQtz.service.ProcedureInvoker;
import com.jadm.springQtz.service.ServiceGeneratedCsv;
import com.jadm.springQtz.service.SesionesAppex;


@Component
public class JobA implements Job {
	
	private static final Logger LOG = LoggerFactory.getLogger(JobA.class);
	
	

    @Autowired
    private ServiceGestorAppex serviceGestorAppex;  
    
    @Autowired
    private SesionesAppex sesionesAppex;
    
    @Autowired
    private ProcedureInvoker procedureInvoker;
    
    @Autowired
    private ServiceGeneratedCsv serviceGeneratedCsv;
    
    @Autowired
    private ServiceListArchExcl serviceListArchExcl;
    
    @Value("${csv.archivo.extension}")
	private String extensionArchivoDescarga;
    
    @Value("${csv.carpeta.bajada}")
	private String carpetaDescargaArchivos;

	@Value("${caracter.separador.carpetas}")
	private String caracterSeparadorCarpetas;
	
	@Value( "${csv.carpeta}" )
	private String carpetaArchivos;
    
	String nameCsv = ServiceGeneratedCsv.nameCsvprevio;
  
    @Override
    public void execute(JobExecutionContext context ) throws JobExecutionException {
    	
    	boolean procesoValido= true;
    	Long Id =0L;
    	BigDecimal in_session_number = null;
    	Long in_Session_NumberToSp=0L;
    	
    	String filepath = carpetaArchivos + caracterSeparadorCarpetas + carpetaDescargaArchivos;
		String ruta_archivo = filepath+caracterSeparadorCarpetas+nameCsv;
       
    	
    	Date fechaSolicitud = new java.sql.Date(new java.util.Date().getTime()); //Fecha se usa paar el gestor
        
    	try {
    		Id = serviceGestorAppex.GenerateIDGestor(fechaSolicitud); //Inserta Nuevo Registro en el Gestor
    	} catch(Exception e) {
			procesoValido= false;
			e.printStackTrace();
			LOG.error("Error al generar nuevo id de gestor", e);
    	}
			LOG.info("Obtiene el Id para gestor :" + Id);
			
		if (procesoValido == true) {	
			try {
				in_session_number = sesionesAppex.getNextSesionId(); // Parametro de Entrada in_session_number Para el Sp GenExlc
				in_Session_NumberToSp = in_session_number.longValue();
			} catch(Exception e) {
				procesoValido= false;
				e.printStackTrace();
				LOG.error("Error al generar nuevo session number", e);
			}
		}
    	
    	LOG.info("Obtiene el session_number :" + in_Session_NumberToSp);
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String in_fecha = sdf.format(fechaSolicitud);
    	
    	LOG.info("Obtiene fecha actual :" + in_fecha);
    	
    	if (procesoValido == true) {	
			try {
				procedureInvoker.CallSp(in_Session_NumberToSp, "in_fecha");
			} catch(Exception e) {
				procesoValido= false;
				e.printStackTrace();
				LOG.error("Error al generar nuevo session number", e);
			}
		}else {serviceGestorAppex.updateGestorNoOk(Id);}
    	
    	//Validacion Salida SP
    	
    	long StatusSp=  procedureInvoker.outputval;
    	
    	LOG.info("Satatus SP: " + StatusSp);
    	
    	 if(StatusSp ==1) {
    		 if (procesoValido == true) {	
    				try {
    					serviceGeneratedCsv.writeCsv(ruta_archivo,in_Session_NumberToSp); // Genera Archivo Csv
    				} catch(Exception e) {
    						procesoValido= false;
    						e.printStackTrace();
    						LOG.error("Error al generar el archivo .csv", e);
    				}
    		 }else {serviceGestorAppex.updateGestorNoOk(Id);}
    		 
    		 if (procesoValido == true) {	
 				try {
 					long numBorrados = serviceListArchExcl.deleteAllBySession(in_Session_NumberToSp);
 				} catch(Exception e) {
					procesoValido= false;
					e.printStackTrace();
					LOG.error("Error al generar el archivo .csv", e);
				}
    		 }else {serviceGestorAppex.updateGestorNoOk(Id);}
    		 
    		 if (procesoValido == true) {	
 				try {
 					boolean actualiacionExitosa = serviceGestorAppex.updateGestor(Id, nameCsv, ruta_archivo);
 				} catch(Exception e) {
					procesoValido= false;
					e.printStackTrace();
					LOG.error("Error al generar el archivo .csv", e);
 				}
    		}else {serviceGestorAppex.updateGestorNoOk(Id);}
    	      LOG.info("Actualiza Gestor");
    }
    	 else {LOG.error("El Sp GenExlc No fue Exitoso");
    	 		serviceGestorAppex.updateGestorNoOk(Id);}
  }
}
