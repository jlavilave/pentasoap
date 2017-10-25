package cl.liberty.prodp.integ.commons.exceptions;

public class IntegSoapPentaExcepcion extends RuntimeException{

	private static final long serialVersionUID = 9129390582627638457L;

	private final String codigoExcepcion;
    private final String glosaExcepcion;
    
    
	public IntegSoapPentaExcepcion(String codigo, String glosa) {
		super(glosa);
		this.codigoExcepcion = codigo;
		this.glosaExcepcion = glosa;
	}

	public String getCodigoExcepcion() {
		return codigoExcepcion;
	}

	public String getGlosaExcepcion() {
		return glosaExcepcion;
	}

}
