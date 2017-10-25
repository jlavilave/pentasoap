package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "documentos")
public class DocTributariosPModel implements Serializable{

	private static final long serialVersionUID = -3409350469205970710L;

	private Long id;
	
	@NotNull(message="211026")
	@Size(min=1, message = "211025")
	private String numDocumento;
	
	@NotNull(message="211027")
	@Min(value=1, message="211028")
	private BigDecimal montoNeto;
	
	@NotNull(message="211029")
	private String fechaDocumento;
	
	@NotNull(message="211031")
	@Size(min=1, max = 2, message = "211030")
	private String tipoDocumento;
	
	@NotNull(message="211034")
	@Size(max = 1, min=1, message = "211036")
	private String tipoBeneficiario;
	
	@NotNull(message="211032")
	@Size(max = 2, min=1, message = "211033")
	private String tipoRegistro;

	private Integer monedaSiniestro;
	
	@NotNull(message="211075")
	@Size(max = 1, message = "211076")
	private String recuperaIva;
	
	@NotNull(message="211077")
	private BigDecimal montoImpuesto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="numeroDocumento")
	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	@XmlElement(name="montoNeto")
	public BigDecimal getMontoNeto() {
		return montoNeto;
	}

	public void setMontoNeto(BigDecimal montoNeto) {
		this.montoNeto = montoNeto;
	}

	@XmlElement(name="fechaDocumento")
	public String getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	@XmlElement(name="tipoDocumento")
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@XmlElement(name="tipoBeneficiario")
	public String getTipoBeneficiario() {
		return tipoBeneficiario;
	}

	public void setTipoBeneficiario(String tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}

	@XmlElement(name="tipoRegistro")
	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	@XmlElement(name="monedaSiniestro")
	public Integer getMonedaSiniestro() {
		return monedaSiniestro;
	}

	public void setMonedaSiniestro(Integer monedaSiniestro) {
		this.monedaSiniestro = monedaSiniestro;
	}

	@XmlElement(name="recuperaIva")
	public String getRecuperaIva() {
		return recuperaIva;
	}

	public void setRecuperaIva(String recuperaIva) {
		this.recuperaIva = recuperaIva;
	}
	
	@XmlElement(name="montoImpuesto")
	public BigDecimal getMontoImpuesto() {
		return montoImpuesto;
	}

	public void setMontoImpuesto(BigDecimal montoImpuesto) {
		this.montoImpuesto = montoImpuesto;
	}

}
