package cl.liberty.prodp.integ.commons.enums;

public enum ScopesOAuth2Enum {
	

	SCOPE_AVISO_REGISTRAR			(1, "IntSOAP.AvisoRegistrar"),
	SCOPE_AVISO_CONSULTAR			(2, "IntSOAP.AvisoConsultarEstado"),
	SCOPE_PAGO_SIN_REGISTRAR		(3, "IntSOAP.PagoSiniestroRegistrar"),
	SCOPE_CHEQUE_CONSULTAR			(4, "IntSOAP.ChequeConsultar"),
	SCOPE_COMISION_REGISTRAR		(5, "IntSOAP.ComisionRegistrar"),
	SCOPE_PAGO_WEB_REGISTRAR		(6, "IntSOAP.PagoWebRegistrar"),
	SCOPE_CONTABILIDAD_REGISTRAR	(7, "IntSOAP.ContabilidadRegistrar")
	
	;
		
	private Integer id;
	private String scope;
	
	private ScopesOAuth2Enum(Integer id, String scope){
		this.id=id;
		this.scope=scope;
	}
	
	public String getScope() {
		return scope;
	}
	
	public Integer getId() {
		return id;
	}

}
