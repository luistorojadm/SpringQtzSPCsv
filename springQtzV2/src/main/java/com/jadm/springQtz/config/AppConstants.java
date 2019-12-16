package com.jadm.springQtz.config;

public class AppConstants {
	
	public static final int RL_DEFAULTVALUE_AJUSTE_IDZONACONTRAPARTIDA = 0;

    // Estado RL "Autorizado" = '3'
    public static final int RL_DEFAULTVALUE_AJUSTE_IDESTADOAJUSTE = 3;

    public static final long RL_DEFAULTVALUE_AJUSTE_IDTALLA = 0L;

    public static final long RL_DEFAULTVALUE_AJUSTE_IDCOLOR = 0L;

    public static final String CURRENCY_CODE_CLP = "CLP";

    public static final String DB_DEFAULT_FIELD_STRING_VALUE = "Sin asignacion";

    public static final int WEB_MAX_USER_LENGTH = 10;

    public static final long DB_DEFAULT_FIELD_NUMERIC_INVALID_VALUE = 99L;

    public static final double DB_DEFAULT_FIELD_NUMERIC_VALUE_DOUBLE = 1.23; // TODO

    public static final long DB_DEFAULT_FIELD_NUMERIC_VALUE_LONG = 0L;

    public static final long UNASSIGNED_NUMERIC_PROPERTY_LONG = -1L;

    public static final int UNASSIGNED_NUMERIC_PROPERTY_INT = -1;

    public static final short AJUSTE_NO_REQUIERE_DOBLE_APROBACION = 0;
    public static final short AJUSTE_SI_REQUIERE_DOBLE_APROBACION = 1;

    public static final String RL_CLASIFICACION_MOTIVO_AJUSTE_AJUSTE = "Ajuste";
    public static final String RL_CLASIFICACION_MOTIVO_AJUSTE_TRANSFERENCIA = "Transferencia";

    public static final int ACCION_MODULO_CARGA = 1;
    public static final int ACCION_MODULO_DESCARGA = 2;

    public static final int MODULO_WEB_1_AJUSTES_TURBO = 1;
    public static final int MODULO_WEB_2_AJUSTES_DETALLE_LOTE_ = 2;
    public static final int MODULO_WEB_3_AJUSTES_CONSULTA = 3;
    public static final int MODULO_WEB_4_GEN_EXCL_ARCHIVO = 4;
    public static final int MODULO_WEB_5_MAPEO_PIX_CONSULTA = 5;

    public static final int ESTADO_PROCESO_GESTOR_1_NO_PROCESADO = 1;
    public static final int ESTADO_PROCESO_GESTOR_2_EN_PROCESO = 2;
    public static final int ESTADO_PROCESO_GESTOR_3_TERMINADO_NOK = 3;
    public static final int ESTADO_PROCESO_GESTOR_4_TERMINADO_OK = 4;

    public static final String FORMATO_FECHA_GESTOR = "yyyy-MM-dd hh:mm:ss";
    public static final String FORMATO_FECHA_LOTES = "dd-MM-yyyy hh:mm:ss";

    public static final String TOPICO_COLA_AJUSTES_CARGA = "ajustes-carga";
    public static final String TOPICO_COLA_AJUSTES_DETALLE_LOTE = "ajustes-detalle-lote";
    public static final String TOPICO_COLA_AJUSTES_CONSULTA = "ajustes-consulta";
    public static final String TOPICO_COLA_MAPEOPIX_CONSULTA = "mapeopix-consulta";
    
    //ServiceGEneraCsv
    
    public static final String RUTA_CSV = "C:\\csv\\";

    // Usuario
    public static final String PREFIJO_ROL_USUARIOS_SOLO_BD = "ROLE_";
    // Acceso a rama arbol menus ajustes
    public static final String ROL_USUARIO_AJUSTES_GENERAL = "AJUSTES";
    public static final String ROL_USUARIO_AJUSTES_MERMAS = "AJUSTES_MERMAS";
    public static final String ROL_USUARIO_AJUSTES_EXISTENCIAS = "AJUSTES_EXISTENCIAS";

    public static final int PAGE_SIZE_BITACORA_MERMAS = 1;
    public static final int PAGE_SIZE_BITACORA_EXISTENCIAS = 1;
    public static final int PAGE_SIZE_GESTOR = 1;
    public static final int PAGE_SIZE_MAPEO_PIX = 1;

    private AppConstants() {}

}// fin enum AppConstants
