package com.jadm.springQtz.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProcedureInvoker {
 
    private final EntityManager entityManager;
 
    @Autowired
    public ProcedureInvoker(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	    
	    public void CallSp(BigDecimal in_session_number, String in_fecha) {
	 
	    
	        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("APPEX_PKG_GEN_EXCL.appex_carga_excl");
	        
	        // Registrar los parámetros de entrada y salida
	        storedProcedureQuery.registerStoredProcedureParameter("in_session_number", BigDecimal.class, ParameterMode.IN);
	        storedProcedureQuery.registerStoredProcedureParameter("in_fecha", String.class, ParameterMode.IN);
	        storedProcedureQuery.registerStoredProcedureParameter("var_out", String.class, ParameterMode.OUT);
	 
	        // Configuramos el valor de entrada
	        storedProcedureQuery.setParameter("in_session_number", in_session_number);
	        storedProcedureQuery.setParameter("in_fecha", in_fecha);
			 
	        // Realizamos la llamada al procedimiento
	        storedProcedureQuery.execute();
	 
	        // Obtenemos los valores de salida
	        final String outputValue1 = (String) storedProcedureQuery.getOutputParameterValue("var_out");
	        
	        System.out.println( outputValue1);
	    }
}

