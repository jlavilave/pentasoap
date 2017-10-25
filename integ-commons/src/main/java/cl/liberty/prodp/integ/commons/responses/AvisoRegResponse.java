package cl.liberty.prodp.integ.commons.responses;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "avisoRegResponse")
public class AvisoRegResponse implements Serializable{

	private static final long serialVersionUID = -2569955084247140564L;

	private Long numeroAviso;
	
	private ErrorResponse error;

	@XmlElement(name="numeroAviso")
	public Long getNumeroAviso() {
		return numeroAviso;
	}

	public void setNumeroAviso(Long numeroAviso) {
		this.numeroAviso = numeroAviso;
	}

	@XmlElement(name="error")
	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

}
