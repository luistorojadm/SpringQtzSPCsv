/**
 * 
 */
package com.jadm.springQtz.service;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer; 
import java.nio.*; 
import java.nio.file.Files; 
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	
	private static final Logger LOG = LoggerFactory.getLogger(ServiceGeneratedCsv.class);
	
	@Value("${ruta.propertis}")
    String rutaProperties;
	
	@Value("${cvs.separator}")
    char separator;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	public static  String fachaActual = sdf.format(new Date());
	
	//public static String nameCsv =(AppConstants.RUTA_CSV.concat(("\\GeExcl").concat(fachaActual).concat(".csv")));
	
	public static String nameCsvprevio =  fachaActual+"-"+"MODULO_GENERADO_EXCLUIDO"+".csv";
	
	public void writeCsv(String nameCsv, Long sessionNumber){
		 Writer writer = null;
		
		try {
			// create a write
			writer = Files.newBufferedWriter(Paths.get(nameCsv));
		
		    
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
		    List<ApexArchExcl> apexArchExclList = serviceListArchExcl.listBySessionNumber(sessionNumber);
		    

		    // write list of objects
		    csvWriter.write(apexArchExclList);

		    // close the writer
		    writer.close();
		    
		    LOG.info("Ruta por properties " + rutaProperties);

		} catch (Exception ex) {
		    ex.printStackTrace();
		    LOG.error("Error al cerrar writer en writeCsv({}, {})", nameCsv, sessionNumber, ex);
		} finally {
			if ( writer != null ) {
                try {
                    writer.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    LOG.error("Error al cerrar writer en writeCsv({}, {})", nameCsv, sessionNumber, e);
                }
            }
		}
	    }
} 

