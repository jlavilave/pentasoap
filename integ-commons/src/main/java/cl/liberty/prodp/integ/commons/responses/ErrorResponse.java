package cl.liberty.prodp.integ.commons.responses;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ErrorResponse")
public class ErrorResponse implements Serializable{

	private static final long serialVersionUID = -6228818668683761637L;

	private String codigo;
	
	private String mensaje;

	@XmlElement(name="codigo")
	public String getCodigo() {
		return codigo;
	}

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@XmlElement(name="mensaje")
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Error [codigo=" + codigo + ", mensaje=" + mensaje + "]";
	}

}
