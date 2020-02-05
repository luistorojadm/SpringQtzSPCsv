package com.jadm.springQtz.service;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProcedureInvoker {
 
    private final EntityManager entityManager;
 
    @Autowired
    public ProcedureInvoker(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	    
    	public static Long outputval;
    	
	    public void CallSp(Long in_session_number, String in_fecha) {
	 
	    
	        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("APPEX_PKG_GEN_EXCL.appex_carga_excl");
	        
	        // Registrar los parámetros de entrada y salida
	        storedProcedureQuery.registerStoredProcedureParameter("in_session_number", Long.class, ParameterMode.IN);
	        storedProcedureQuery.registerStoredProcedureParameter("in_fecha", String.class, ParameterMode.IN);
	        storedProcedureQuery.registerStoredProcedureParameter("var_out", Long.class, ParameterMode.OUT);
	 
	        // Configuramos el valor de entrada
	        storedProcedureQuery.setParameter("in_session_number", in_session_number);
	        storedProcedureQuery.setParameter("in_fecha", in_fecha);
			 
	        // Realizamos la llamada al procedimiento
	        try {
	        storedProcedureQuery.execute();
	        } catch (QueryTimeoutException qt) {
	            qt.printStackTrace();
	        }
	        catch (PersistenceException e) {
	            e.printStackTrace();
	        }
	 
	        // Obtenemos los valores de salida
	        final Long outputValue1 = (Long) storedProcedureQuery.getOutputParameterValue("var_out");
	        
	        System.out.println( outputValue1);
	        outputval = outputValue1;
	    }
}

