package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "consultaCheque")
public class ParamConsultaChequePModel implements Serializable{

	private static final long serialVersionUID = 8421947747137219235L;
	
	@NotNull(message="213005")
	@Min(value=1, message="213006")
	private Long numeroSiniestro;
	
	@NotNull(message="213008")
	@Min(value=1, message="213009")
	private Long numeroLiquidacion;
	
	@NotNull(message="213010")
	@Min(value=1, message="213010")
	private Integer codigoOrigen;
	
	@NotNull(message="213012")
	@Size(max=15, min=1, message="213011")
	private String rutBeneficiario;
	
	@NotNull(message="213015")
	@Size(min=1, message="213014")
	private String nombreUsuario;
	
	private Integer tipoDocumento;
	
	@XmlElement(name="numeroSiniestro")
	public Long getNumeroSiniestro() {
		return numeroSiniestro;
	}
	public void setNumeroSiniestro(Long numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}
	
	@XmlElement(name="numeroLiquidacion")
	public Long getNumeroLiquidacion() {
		return numeroLiquidacion;
	}
	public void setNumeroLiquidacion(Long numeroLiquidacion) {
		this.numeroLiquidacion = numeroLiquidacion;
	}
	
	@XmlElement(name="codigoOrigen")
	public Integer getCodigoOrigen() {
		return codigoOrigen;
	}
	public void setCodigoOrigen(Integer codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}
	
	@XmlElement(name="rutBeneficiario")
	public String getRutBeneficiario() {
		return rutBeneficiario;
	}
	public void setRutBeneficiario(String rutBeneficiario) {
		this.rutBeneficiario = rutBeneficiario;
	}
	
	@XmlElement(name="nombreUsuario")
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@XmlElement(name="tipoDocumento")
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	
}
