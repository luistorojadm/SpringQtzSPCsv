package com.jadm.springQtz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="APPEX_ARCH_GESTOR")
public class Gestor {

    // TODO ColumnDefinitions Oracle

    /**
     * PK: Codigo unico (secuencia)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 1: Carga
     * 2: Descarga
     */
    @Column(columnDefinition = "number(2)")
    private int codigoAccion;

    /**
     * Fecha fin del proceso que ejecuta la accion descrita en el registro de esta tabla
     */
    @Column(columnDefinition = "date")
    private Date fechaFinProceso;

    /**
     * Fecha solicitud (creacion del registro en esta tabla)
     */
    @Column(columnDefinition = "date")
    private Date fechaSolicitud;

    /**
     * Ruta completa archivo a subir o descargar
     */
    @Column(columnDefinition = "varchar2(255)")
    private String rutaArchivo;

    /**
     * Codigo del modulo que genero solicitud
     * @see
     */
    // TODO: Asociar clase referencial en Javadoc
    @Column(columnDefinition = "number(3)")
    private int codigoModuloOrigen;

    /**
     * Estatus del proceso:
     * - ESTADO_PROCESO_GESTOR_1_NO_PROCESADO = 1
     * - ESTADO_PROCESO_GESTOR_2_EN_PROCESO = 2;
     * - ESTADO_PROCESO_GESTOR_3_TERMINADO_NOK = 3;
     * - ESTADO_PROCESO_GESTOR_4_TERMINADO_OK = 4;
     */
    @Column(columnDefinition = "number(2)")
    private int estado;

    /**
     * Usuario (Web) asociado al registro
     *
     * (Por defecto en Oracle, sin la anotacion @Column(columnDefinition=...), es varchar2(255)
     */
    private String usuario;

    /**
     * Json con los parametros de la consulta Web del modulo asociado
     */
    @Column(columnDefinition = "varchar2(1024)")
    private String queryConsultaWeb;

    public Gestor(int codigoAccion, Date fechaFinProceso, Date fechaSolicitud, String rutaArchivo, int codigoModuloOrigen, int estado, String usuario, String queryConsultaWeb) {
        this.codigoAccion = codigoAccion;
        this.fechaFinProceso = fechaFinProceso;
        this.fechaSolicitud = fechaSolicitud;
        this.rutaArchivo = rutaArchivo;
        this.codigoModuloOrigen = codigoModuloOrigen;
        this.estado = estado;
        this.usuario = usuario;
        this.queryConsultaWeb = queryConsultaWeb;
    } // fin Gestor(long gest_action, String gest_date_processed, String gest_date_requested, String gest_filename, long gest_source, long gest_status, String gest_user, String gest_userquery)

    public Gestor() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCodigoAccion() {
        return codigoAccion;
    }

    public void setCodigoAccion(int codigoAccion) {
        this.codigoAccion = codigoAccion;
    }

    public Date getFechaFinProceso() {
        return fechaFinProceso;
    }

    public void setFechaFinProceso(Date fechaFinProceso) {
        this.fechaFinProceso = fechaFinProceso;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public int getCodigoModuloOrigen() {
        return codigoModuloOrigen;
    }

    public void setCodigoModuloOrigen(int codigoModuloOrigen) {
        this.codigoModuloOrigen = codigoModuloOrigen;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getQueryConsultaWeb() {
        return queryConsultaWeb;
    }

    public void setQueryConsultaWeb(String queryConsultaWeb) {
        this.queryConsultaWeb = queryConsultaWeb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gestor:\n{")
            .append("  gest_sequence='").append(id).append("'\n")
            .append(", gest_action='").append(codigoAccion).append("'\n")
            .append(", gest_date_processed='").append(fechaFinProceso).append("'\n")
            .append(", gest_date_requested='").append(fechaSolicitud).append("'\n")
            .append(", gest_filename='").append(rutaArchivo).append("'\n")
            .append(", gest_source='").append(codigoModuloOrigen).append("'\n")
            .append(", gest_status='").append(estado).append("'\n")
            .append(", gest_user='").append(usuario).append("'\n")
            .append(", gest_userquery='").append(queryConsultaWeb).append("'\n")
            .append('}');
        return sb.toString();
    } // fin toString()

    public static class GestorBuilder {
        private int accion;
        private Date fecha_proceso;
        private Date fecha_creacion;
        private String nombre_archivo;
        private int origen_modulo;
        private int estado;
        private String usuario;
        private String query_usuario;

        public GestorBuilder accion(int val) {
            accion = val;
            return this;
        } // fin GestorBuilder accion(int val)

        public GestorBuilder fecha_proceso(Date val) {
            fecha_proceso = val;
            return this;
        } // fin GestorBuilder fecha_proceso(Date val)

        public GestorBuilder fecha_creacion(Date val) {
            fecha_creacion = val;
            return this;
        } // fin GestorBuilder fecha_creacion(Date val)

        public GestorBuilder nombre_archivo(String val) {
            nombre_archivo = val;
            return this;
        } // fin GestorBuilder nombre_archivo(String val)

        public GestorBuilder origen_modulo(int val) {
            origen_modulo = val;
            return this;
        } // fin GestorBuilder origen_modulo(int val)

        public GestorBuilder estado(int val) {
            estado = val;
            return this;
        } // fin GestorBuilder estado(int val)

        public GestorBuilder usuario(String val) {
            usuario = val;
            return this;
        } // fin GestorBuilder usuario(String val)

        public GestorBuilder query_usuario(String val) {
            query_usuario = val;
            return this;
        } // fin GestorBuilder query_usuario(String val)

        public Gestor build() {
            return new Gestor(this);
        } // fin Gestor build()
    } // fin static class GestorBuilder

    private Gestor(GestorBuilder builder) {
        codigoAccion = builder.accion;
        fechaFinProceso = builder.fecha_proceso;
        fechaSolicitud = builder.fecha_creacion;
        rutaArchivo = builder.nombre_archivo;
        codigoModuloOrigen = builder.origen_modulo;
        estado = builder.estado;
        usuario = builder.usuario;
        queryConsultaWeb = builder.query_usuario;
    } // fin Gestor(GestorBuilder builder)

} // fin class Gestor