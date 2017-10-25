package cl.liberty.prodp.integ.commons.responses;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pagoWebResponse")
public class PagoWebResponse implements Serializable{

	private static final long serialVersionUID = 7296240887565986897L;

	private Long numeroAviso;
	
	private Long comprobantePago;
	
	@XmlElement(name="numeroAviso")
	public Long getNumeroAviso() {
		return numeroAviso;
	}

	public void setNumeroAviso(Long numeroAviso) {
		this.numeroAviso = numeroAviso;
	}

	@XmlElement(name="comprobantePago")
	public Long getComprobantePago() {
		return comprobantePago;
	}

	public void setComprobantePago(Long comprobantePago) {
		this.comprobantePago = comprobantePago;
	}

	private ErrorResponse error;

	@XmlElement(name="error")
	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

}
