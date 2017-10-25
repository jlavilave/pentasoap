package cl.liberty.prodp.integ.commons.responses;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "consultaEstadoResponse")
public class ConsultaEstadoResponse implements Serializable{

	private static final long serialVersionUID = 6904112401452734437L;

	private String codigoEstado;
	
	private String fechaUltimoMov;
	
	private ErrorResponse error;

	@XmlElement(name="codigoEstado")
	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	@XmlElement(name="fechaUltimoMovimiento")
	public String getFechaUltimoMov() {
		return fechaUltimoMov;
	}

	public void setFechaUltimoMov(String fechaUltimoMov) {
		this.fechaUltimoMov = fechaUltimoMov;
	}

	@XmlElement(name="error")
	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}
	
	
	
}
