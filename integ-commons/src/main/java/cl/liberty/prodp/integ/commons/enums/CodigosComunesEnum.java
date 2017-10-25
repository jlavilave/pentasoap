package cl.liberty.prodp.integ.commons.enums;

public enum CodigosComunesEnum {

	//Códigos comunes
	ERROR_ARCHIVO_PROPERTIES		("010003"),
	ERROR_NO_DIFERENCIABLE			("010004"),
	ERROR_CONVERSION_XML			("010005"),
	ERROR_RESTCLIENT_FILESTREAM		("010006"),
	ERROR_RESTCLIENT_TIMEOUT		("010007"),
	ERROR_RESTCLIENT_BADREQUEST		("010008"),
	ERROR_RESTCLIENT_ERROAUTH2		("010009"),
	
	;
		
	private String codigo;
	
	private CodigosComunesEnum(String codigo){
		this.codigo=codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
}
