package com.jadm.springQtz.Jobs;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jadm.springQtz.service.ServiceA;
import com.jadm.springQtz.service.ServiceGeneratedCsv;
import com.jadm.springQtz.service.ServiceUpdateGestor;


@Component
public class JobB implements Job {
	
	private static final Logger LOG = LoggerFactory.getLogger(JobB.class);
	
	@Autowired
	private ServiceUpdateGestor serviceUpdateGestor;
	
	Long Id = ServiceA.IdGestor;
	String nameCsv = ServiceGeneratedCsv.nameCsv;
	
	private Date fechaFinProceso= new Date();
		
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	LOG.info("Obtiene el Id para UpdateGestorr :" + Id);
    	
    	serviceUpdateGestor.updateGestor(Id, fechaFinProceso, nameCsv);
    	
    	LOG.info("Obtiene el Id para UpdateGestor :" + Id);
    	System.out.println("Actualiza Generador");
    	}
    }

