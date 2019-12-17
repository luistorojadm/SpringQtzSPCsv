/**
 * 
 */
package com.jadm.springQtz.service;


import java.io.File;
import java.io.FileWriter; 
import java.io.Writer; 
import java.nio.*; 
import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${ruta.propertis}")
    String rutaProperties;
	
	@Value("${cvs.separator}")
    char separator;
	
	public static  String fachaActual = serviceDate.getStringDate();
	
	public static String nameCsv =(AppConstants.RUTA_CSV.concat(("\\GeExcl").concat(fachaActual).concat(".csv")));
	
	public void writeCsv(){
		
		try {
			// create a write
			Writer writer = Files.newBufferedWriter(Paths.get(nameCsv));
		
		    
		    HeaderColumnNameMappingStrategy<ApexArchExcl> strategy = new HeaderColumnNameMappingStrategy<>();
		      strategy.setType(ApexArchExcl.class);

		    //char separator = ';';
			// create a csv writer
		    StatefulBeanToCsv<ApexArchExcl> csvWriter = new StatefulBeanToCsvBuilder<ApexArchExcl>(writer)
		    		.withSeparator(separator )
		            //.withSeparator(CSVWriter.DEFAULT_SEPARATOR =';')
		            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
		            .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
		            .withLineEnd(CSVWriter.DEFAULT_LINE_END)
		            .withMappingStrategy(strategy)
		            .withOrderedResults(false)
		            .build();
		    
		    

		    // create a list of objects
		    List<ApexArchExcl> apexArchExclList = serviceListArchExcl.listAll();
		    

		    // write list of objects
		    csvWriter.write(apexArchExclList);

		    // close the writer
		    writer.close();
		    
		    LOG.info("Ruta PASADA POR PROPERTI " + rutaProperties);

		} catch (Exception ex) {
		    ex.printStackTrace();
		    
		}
	    }
} 

