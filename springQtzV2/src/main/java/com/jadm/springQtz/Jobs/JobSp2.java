package com.jadm.springQtz.Jobs;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jadm.springQtz.repository.ProcedureInvoker;
import com.jadm.springQtz.service.ServiceUpdateGestor;
import com.jadm.springQtz.service.SesionesAppex;
/*
@Slf4j
@Component
public class JobSp2 implements Job {
	
	@Autowired
	private ServiceUpdateGestor serviceUpdateGestor;
	
	@Autowired
	private JobA jobA;
	

    @Override
    public void execute(JobExecutionContext context) {
    	
    	
    	Date fechaFinProceso = new Date(); 
    	
    //	serviceUpdateGestor.updateGestor(Id, fechaFinProceso);   
    	
    	System.out.println("Actualiza tabla Gestor");
    }
    
    
}
*/