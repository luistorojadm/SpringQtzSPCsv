/**
 * 
 */
package com.jadm.springQtz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

/**
 * @author JAMD  Tabla que representa GeneraExcl
 *
 */
@Entity
@Table(name="APPEX_ARCH_EXCL", catalog = "APP_SAM")
public class ApexArchExcl {
	@CsvBindByName
	@CsvBindByPosition(position = 0)
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SESSION_NUMBER")
    private long session_number;
	
	@CsvBindByName
	@CsvBindByPosition(position = 1)
	@Column(name="MOTIVO")
    private String motivo;
	
	@CsvBindByName
	@CsvBindByPosition(position = 2)
	@Column(name="PMH_WAREHOUSE")
    private long pmh_warehouse;
	
	@CsvBindByName
	@CsvBindByPosition(position = 3)
	@Column(name="ORG_NAME_FULL")
    private String org_name_full;
	
	@CsvBindByName
	@CsvBindByPosition(position = 4)
	@Column(name="PRD_NAME_RUBRO")
    private String prd_name_rubro;
	
	@CsvBindByName
	@CsvBindByPosition(position = 5)
	@Column(name="PRD_NAME_SUBRUBRO")
    private String prd_name_subrubro;
	
	@CsvBindByName
	@CsvBindByPosition(position = 6)
	@Column(name="PRD_NAME_CLASE")
    private String prd_name_clase;
	
	@CsvBindByName
	@CsvBindByPosition(position = 7)
	@Column(name="ATR_CODE_MARCA")
    private String atr_code_marca;
	
	@CsvBindByName
	@CsvBindByPosition(position = 8)
	@Column(name="ATR_DESC_MARCA")
    private String atr_desc_marca;
	
	@CsvBindByName
	@CsvBindByPosition(position = 9)
	@Column(name="ATR_CODE_TEMP")
    private String atr_code_temp;
	
	@CsvBindByName
	@CsvBindByPosition(position = 10)
	@Column(name="ATR_DESC_TEMP")
    private String atr_desc_temp;
	
	@CsvBindByName
	@CsvBindByPosition(position =11)
	@Column(name="ATR_CODE_CICLO")
    private String atr_code_ciclo;
	
	@CsvBindByName
	@CsvBindByPosition(position = 12)
	@Column(name="ATR_DESC_CICLO")
    private String atr_desc_ciclo;

	@CsvBindByName
	@CsvBindByPosition(position = 13)
	@Column(name="ATR_CODE_TEMCO")
    private String atr_code_temco;
	
	@CsvBindByName
	@CsvBindByPosition(position = 14)
	@Column(name="ATR_DESC_TEMCO")
    private String atr_desc_temco;
	
	@CsvBindByName
	@CsvBindByPosition(position = 15)
	@Column(name="ATR_CODE_TEMCP")
    private String atr_code_temcp;
	
	@CsvBindByName
	@CsvBindByPosition(position = 16)
	@Column(name="ATR_DESC_TEMCP")
    private String atr_desc_temcp;
	
	@CsvBindByName
	@CsvBindByPosition(position = 17)
	@Column(name="CASE_PACK_ID")
    private String case_pack_id;
	
	@CsvBindByName
	@CsvBindByPosition(position = 18)
	@Column(name="PRD_LVL_NUMBER")
    private String prd_lvl_number;
	
	@CsvBindByName
	@CsvBindByPosition(position = 19)
	@Column(name="PRD_NAME_FULL")
    private String prd_name_full;
	
	@CsvBindByName
	@CsvBindByPosition(position = 20)
	@Column(name="RPL_DIST_METHOD")
    private String rpl_dist_method;
	
	@CsvBindByName
	@CsvBindByPosition(position = 21)
	@Column(name="RPL_FC_WKLY_SLS")
    private long rpl_fc_wkly_sls;
	
	@CsvBindByName
	@CsvBindByPosition(position = 22)
	@Column(name="ON_HAND_QTY")
    private long on_hand_qty;
	
	@CsvBindByName
	@CsvBindByPosition(position = 23)
	@Column(name="TO_ORD_QTY")
    private long to_ord_qty;
	
	@CsvBindByName
	@CsvBindByPosition(position = 24)
	@Column(name="PO_ORDER_QTY")
    private long po_order_qty;
	
	@CsvBindByName
	@CsvBindByPosition(position = 25)
	@Column(name="TO_INTRN_QTY")
    private long to_intrn_qty;
	
	@CsvBindByName
	@CsvBindByPosition(position = 26)
	@Column(name="STOCK_TOTAL")
    private long stock_total;
	
	@CsvBindByName
	@CsvBindByPosition(position = 27)
	@Column(name="ORDER_AMT")
    private long orden_amt;

	//Constructor Vacio
	public ApexArchExcl() {
		
	}

	
	public ApexArchExcl(long session_number, String motivo, long pmh_warehouse, String org_name_full,
			String prd_name_rubro, String prd_name_subrubro, String prd_name_clase, String atr_code_marca,
			String atr_desc_marca, String atr_code_temp, String atr_desc_temp, String atr_code_ciclo,
			String atr_desc_ciclo, String atr_code_temco, String atr_desc_temco, String atr_code_temcp,
			String atr_desc_temcp, String case_pack_id, String prd_lvl_number, String prd_name_full,
			String rpl_dist_method, long rpl_fc_wkly_sls, long on_hand_qty, long to_ord_qty, long po_order_qty,
			long to_intrn_qty, long stock_total, long orden_amt) {
		super();
		this.session_number = session_number;
		this.motivo = motivo;
		this.pmh_warehouse = pmh_warehouse;
		this.org_name_full = org_name_full;
		this.prd_name_rubro = prd_name_rubro;
		this.prd_name_subrubro = prd_name_subrubro;
		this.prd_name_clase = prd_name_clase;
		this.atr_code_marca = atr_code_marca;
		this.atr_desc_marca = atr_desc_marca;
		this.atr_code_temp = atr_code_temp;
		this.atr_desc_temp = atr_desc_temp;
		this.atr_code_ciclo = atr_code_ciclo;
		this.atr_desc_ciclo = atr_desc_ciclo;
		this.atr_code_temco = atr_code_temco;
		this.atr_desc_temco = atr_desc_temco;
		this.atr_code_temcp = atr_code_temcp;
		this.atr_desc_temcp = atr_desc_temcp;
		this.case_pack_id = case_pack_id;
		this.prd_lvl_number = prd_lvl_number;
		this.prd_name_full = prd_name_full;
		this.rpl_dist_method = rpl_dist_method;
		this.rpl_fc_wkly_sls = rpl_fc_wkly_sls;
		this.on_hand_qty = on_hand_qty;
		this.to_ord_qty = to_ord_qty;
		this.po_order_qty = po_order_qty;
		this.to_intrn_qty = to_intrn_qty;
		this.stock_total = stock_total;
		this.orden_amt = orden_amt;
	}


	public long getSession_number() {
		return session_number;
	}


	public void setSession_number(long session_number) {
		this.session_number = session_number;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public long getPmh_warehouse() {
		return pmh_warehouse;
	}


	public void setPmh_warehouse(long pmh_warehouse) {
		this.pmh_warehouse = pmh_warehouse;
	}


	public String getOrg_name_full() {
		return org_name_full;
	}


	public void setOrg_name_full(String org_name_full) {
		this.org_name_full = org_name_full;
	}


	public String getPrd_name_rubro() {
		return prd_name_rubro;
	}


	public void setPrd_name_rubro(String prd_name_rubro) {
		this.prd_name_rubro = prd_name_rubro;
	}


	public String getPrd_name_subrubro() {
		return prd_name_subrubro;
	}


	public void setPrd_name_subrubro(String prd_name_subrubro) {
		this.prd_name_subrubro = prd_name_subrubro;
	}


	public String getPrd_name_clase() {
		return prd_name_clase;
	}


	public void setPrd_name_clase(String prd_name_clase) {
		this.prd_name_clase = prd_name_clase;
	}


	public String getAtr_code_marca() {
		return atr_code_marca;
	}


	public void setAtr_code_marca(String atr_code_marca) {
		this.atr_code_marca = atr_code_marca;
	}


	public String getAtr_desc_marca() {
		return atr_desc_marca;
	}


	public void setAtr_desc_marca(String atr_desc_marca) {
		this.atr_desc_marca = atr_desc_marca;
	}


	public String getAtr_code_temp() {
		return atr_code_temp;
	}


	public void setAtr_code_temp(String atr_code_temp) {
		this.atr_code_temp = atr_code_temp;
	}


	public String getAtr_desc_temp() {
		return atr_desc_temp;
	}


	public void setAtr_desc_temp(String atr_desc_temp) {
		this.atr_desc_temp = atr_desc_temp;
	}


	public String getAtr_code_ciclo() {
		return atr_code_ciclo;
	}


	public void setAtr_code_ciclo(String atr_code_ciclo) {
		this.atr_code_ciclo = atr_code_ciclo;
	}


	public String getAtr_desc_ciclo() {
		return atr_desc_ciclo;
	}


	public void setAtr_desc_ciclo(String atr_desc_ciclo) {
		this.atr_desc_ciclo = atr_desc_ciclo;
	}


	public String getAtr_code_temco() {
		return atr_code_temco;
	}


	public void setAtr_code_temco(String atr_code_temco) {
		this.atr_code_temco = atr_code_temco;
	}


	public String getAtr_desc_temco() {
		return atr_desc_temco;
	}


	public void setAtr_desc_temco(String atr_desc_temco) {
		this.atr_desc_temco = atr_desc_temco;
	}


	public String getAtr_code_temcp() {
		return atr_code_temcp;
	}


	public void setAtr_code_temcp(String atr_code_temcp) {
		this.atr_code_temcp = atr_code_temcp;
	}


	public String getAtr_desc_temcp() {
		return atr_desc_temcp;
	}


	public void setAtr_desc_temcp(String atr_desc_temcp) {
		this.atr_desc_temcp = atr_desc_temcp;
	}


	public String getCase_pack_id() {
		return case_pack_id;
	}


	public void setCase_pack_id(String case_pack_id) {
		this.case_pack_id = case_pack_id;
	}


	public String getPrd_lvl_number() {
		return prd_lvl_number;
	}


	public void setPrd_lvl_number(String prd_lvl_number) {
		this.prd_lvl_number = prd_lvl_number;
	}


	public String getPrd_name_full() {
		return prd_name_full;
	}


	public void setPrd_name_full(String prd_name_full) {
		this.prd_name_full = prd_name_full;
	}


	public String getRpl_dist_method() {
		return rpl_dist_method;
	}


	public void setRpl_dist_method(String rpl_dist_method) {
		this.rpl_dist_method = rpl_dist_method;
	}


	public long getRpl_fc_wkly_sls() {
		return rpl_fc_wkly_sls;
	}


	public void setRpl_fc_wkly_sls(long rpl_fc_wkly_sls) {
		this.rpl_fc_wkly_sls = rpl_fc_wkly_sls;
	}


	public long getOn_hand_qty() {
		return on_hand_qty;
	}


	public void setOn_hand_qty(long on_hand_qty) {
		this.on_hand_qty = on_hand_qty;
	}


	public long getTo_ord_qty() {
		return to_ord_qty;
	}


	public void setTo_ord_qty(long to_ord_qty) {
		this.to_ord_qty = to_ord_qty;
	}


	public long getPo_order_qty() {
		return po_order_qty;
	}


	public void setPo_order_qty(long po_order_qty) {
		this.po_order_qty = po_order_qty;
	}


	public long getTo_intrn_qty() {
		return to_intrn_qty;
	}


	public void setTo_intrn_qty(long to_intrn_qty) {
		this.to_intrn_qty = to_intrn_qty;
	}


	public long getStock_total() {
		return stock_total;
	}


	public void setStock_total(long stock_total) {
		this.stock_total = stock_total;
	}


	public long getOrden_amt() {
		return orden_amt;
	}


	public void setOrden_amt(long orden_amt) {
		this.orden_amt = orden_amt;
	}
	
	
	


	
	
}
