/**
 * 
 */
package com.jadm.springQtz.service;


import java.io.FileWriter; 
import java.io.Writer; 
import java.nio.*; 
import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadm.springQtz.Jobs.JobC;
import com.jadm.springQtz.config.AppConstants;
import com.jadm.springQtz.model.ApexArchExcl;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv; 
import com.opencsv.bean.StatefulBeanToCsvBuilder;

/**
 * @author jadm
 *
 */

@Service
public class ServiceGeneratedCsv {
	
	@Autowired
	private ServiceListArchExcl serviceListArchExcl;
	
	private static final Logger LOG = LoggerFactory.getLogger(JobC.class);
	
	private static ServiceDate serviceDate;
	
	//public static String rutaCsv = (AppConstants.RUTA_CSV);
	
	public static  String fachaActual = serviceDate.getStringDate();
	
	public static String nameCsv = (AppConstants.RUTA_CSV.concat("GeExcl").concat(fachaActual).concat(".csv"));
	
	
	public void writeCsv(){
		
		try {
			// create a write
		    Writer writer = Files.newBufferedWriter(Paths.get(nameCsv));
		    
		    HeaderColumnNameMappingStrategy<ApexArchExcl> strategy = new HeaderColumnNameMappingStrategy<>();
		      strategy.setType(ApexArchExcl.class);

		    // create a csv writer
		    StatefulBeanToCsv<ApexArchExcl> csvWriter = new StatefulBeanToCsvBuilder<ApexArchExcl>(writer)
		            .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
		            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
		            .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
		            .withLineEnd(CSVWriter.DEFAULT_LINE_END)
		            .withMappingStrategy(strategy)
		            .withOrderedResults(false)
		            .build();
		    
		    

		    // create a list of objects (`User`)
		    List<ApexArchExcl> apexArchExclList = serviceListArchExcl.listAll();
		    

		    // write list of objects
		    csvWriter.write(apexArchExclList);

		    // close the writer
		    writer.close();
		    
		    LOG.info("Creacion de Archivo .CSV  ");

		} catch (Exception ex) {
		    ex.printStackTrace();
		    
		}
	    }
} 

