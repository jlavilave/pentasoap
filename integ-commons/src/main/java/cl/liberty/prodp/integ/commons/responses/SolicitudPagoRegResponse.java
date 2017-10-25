package cl.liberty.prodp.integ.commons.responses;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "solicitudPagoRegResponse")
public class SolicitudPagoRegResponse implements Serializable{

	private static final long serialVersionUID = 7364085674204178660L;
	
	private ErrorResponse error;

	@XmlElement(name="error")
	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}
	
	

}
