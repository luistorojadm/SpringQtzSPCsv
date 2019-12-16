package com.jadm.springQtz.Jobs;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jadm.springQtz.config.AppConstants;
import com.jadm.springQtz.model.ApexArchExcl;
import com.jadm.springQtz.service.ServiceDate;
import com.jadm.springQtz.service.ServiceGeneratedCsv;
import com.jadm.springQtz.service.ServiceListArchExcl;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Component
public class JobC implements Job {
	
	private static final Logger LOG = LoggerFactory.getLogger(JobC.class);
	
	@Autowired
	private ServiceGeneratedCsv serviceGeneratedCsv;
	
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    
    	serviceGeneratedCsv.writeCsv();
    	
    }   	
}
            
    

