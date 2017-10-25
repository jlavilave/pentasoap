package cl.liberty.prodp.integ.commons.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "comisionRegResponse")
public class ComisionRegResponse {
	
	private String codigoCorredorLiberty;
	
	private ErrorResponse error;

	@XmlElement(name="codigoCorredorLiberty")
	public String getCodigoCorredorLiberty() {
		return codigoCorredorLiberty;
	}

	public void setCodigoCorredorLiberty(String codigoCorredorLiberty) {
		this.codigoCorredorLiberty = codigoCorredorLiberty;
	}

	@XmlElement(name="error")
	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

}
