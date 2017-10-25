package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "consultaEstado")
public class ParamConsultaEstadoPModel implements Serializable{

	private static final long serialVersionUID = -1181590603745582050L;

	@NotNull(message="112003")
	@Min(value=1, message="112004")
	private Long numeroAviso;
	
	private Integer codigoOrigen;
	
	@NotNull(message="112005")
	private String nombreUsuario;

	@XmlElement(name="numeroAviso")
	public Long getNumeroAviso() {
		return numeroAviso;
	}

	public void setNumeroAviso(Long numeroAviso) {
		this.numeroAviso = numeroAviso;
	}

	@XmlElement(name="codigoOrigen")
	public Integer getCodigoOrigen() {
		return codigoOrigen;
	}

	public void setCodigoOrigen(Integer codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	@XmlElement(name="nombreUsuario")
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
