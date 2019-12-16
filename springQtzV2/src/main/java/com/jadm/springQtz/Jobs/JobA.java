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
    
    
    
  
    @Override
    public void execute(JobExecutionContext context ) throws JobExecutionException {
       
    	
    	Date fechaSolicitud = serviceDate.getDate();
        long Id = serviceA.GenerateIDGestor(fechaSolicitud);
    	
    	LOG.info("Obtiene el Id para gestor :" + Id);
    	  	
    	
    	BigDecimal in_session_number = sesionesAppex.getNextSesionId(); 
    	
    	LOG.info("Obtiene el session_number :" + in_session_number);
    	
    	String in_fecha =serviceDate.getStringDate();
    	
    	LOG.info("Obtiene fecha actual :" + in_fecha);
    	
    	System.out.println("Fecha   " + in_fecha );
    	
    	//procedureInvoker.CallSp(in_session_number, "in_fecha");   	
        
        
        System.out.println("I am scheduled on " + new Date(System.currentTimeMillis()));
    }
    
}
