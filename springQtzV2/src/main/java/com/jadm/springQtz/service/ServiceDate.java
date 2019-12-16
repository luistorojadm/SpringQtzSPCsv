/**
 * 
 */
package com.jadm.springQtz.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * @author ivega
 *
 */
@Service
public class ServiceDate {
	
	public Date getDate() {
		Date DateActual = new Date();
		return  DateActual; 
	} 
	
	public static String getStringDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		String fechaComoCadena = sdf.format(new Date());
		return  fechaComoCadena;
		
		//"yyyy-MM-dd HH:mm:ss"
	} 

}
