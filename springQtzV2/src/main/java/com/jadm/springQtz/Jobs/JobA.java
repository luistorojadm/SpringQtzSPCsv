package com.jadm.springQtz.Jobs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jadm.springQtz.repository.ProcedureInvoker;
import com.jadm.springQtz.service.ServiceA;
import com.jadm.springQtz.service.ServiceDate;
import com.jadm.springQtz.service.ServiceGeneratedCsv;
import com.jadm.springQtz.service.ServiceUpdateGestor;
import com.jadm.springQtz.service.SesionesAppex;


@Component
public class JobA implements Job {
	
	private static final Logger LOG = LoggerFactory.getLogger(JobA.class);
	
	

    @Autowired
    private ServiceA serviceA;  
    
    @Autowired
    private SesionesAppex sesionesAppex;
    
    @Autowired
    private ServiceDate serviceDate;
    
    @Autowired
    private ProcedureInvoker procedureInvoker;
    
    @Autowired
    private ServiceGeneratedCsv serviceGeneratedCsv;
    
    @Autowired
	private ServiceUpdateGestor serviceUpdateGestor;
    
    
    Long Id = ServiceA.IdGestor;
	String nameCsv = ServiceGeneratedCsv.nameCsv;
	
	private Date fechaFinProceso= new Date();   
   
  
    @Override
    public void execute(JobExecutionContext context ) throws JobExecutionException {
       
    	
    	Date fechaSolicitud = serviceDate.getDate(); //Fecha se inserta Junto al ID
        
    	long Id = serviceA.GenerateIDGestor(fechaSolicitud); //Inserta Nuevo Registro en el Gestor
    	
    	LOG.info("Obtiene el Id para gestor :" + Id);
    	  	
    	
    	BigDecimal in_session_number = sesionesAppex.getNextSesionId(); // Parametro de Entrada in_session_number Para el Sp GenExlc 
    	
    	LOG.info("Obtiene el session_number :" + in_session_number);
    	
    	String in_fecha =serviceDate.getStringDate(); //Parametro de Entrada in_session_number Para el Sp GenExlc
    	
    	LOG.info("Obtiene fecha actual :" + in_fecha);
    	
    	
    	procedureInvoker.CallSp(in_session_number, "in_fecha");   	
    	
    	
    	//Validacion Salida SP
    	//final String var_out ="OK" ;
    	
    		//if(var_out =="OK") {
    	
    	serviceGeneratedCsv.writeCsv(); // Genera Archivo Csv
    	       	   	
       	serviceUpdateGestor.updateGestor(Id, fechaFinProceso, nameCsv); //Actualiza Gestor
       	
       		
       		System.out.println("Actualiza Generador");
    	   
    			
    		//}LOG.error("El Sp GenExlc No fue Exitoso");
        
    }
    
}
