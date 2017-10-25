package cl.liberty.prodp.integ.commons.responses;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cheque")
public class ChequeResponse implements Serializable{

	private static final long serialVersionUID = -4242316152302288429L;

	private Long numeroCheque;
	private String serieCheque;
	private String bancoEmisor;
	private String fechaEmision;
	private BigDecimal montoPagado;
	private BigDecimal montoSiniestro;
	private String rutBeneficiario;
	private String nombreBeneficiario;
	
	@XmlElement(name="numeroCheque")
	public Long getNumeroCheque() {
		return numeroCheque;
	}
	public void setNumeroCheque(Long numeroCheque) {
		this.numeroCheque = numeroCheque;
	}
	
	@XmlElement(name="serieCheque")
	public String getSerieCheque() {
		return serieCheque;
	}
	public void setSerieCheque(String serieCheque) {
		this.serieCheque = serieCheque;
	}
	
	@XmlElement(name="bancoEmisor")
	public String getBancoEmisor() {
		return bancoEmisor;
	}
	public void setBancoEmisor(String bancoEmisor) {
		this.bancoEmisor = bancoEmisor;
	}
	
	@XmlElement(name="fechaEmision")
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	@XmlElement(name="montoPagado")
	public BigDecimal getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(BigDecimal montoPagado) {
		this.montoPagado = montoPagado;
	}
	@XmlElement(name="montoSiniestro")
	public BigDecimal getMontoSiniestro() {
		return montoSiniestro;
	}
	public void setMontoSiniestro(BigDecimal montoSiniestro) {
		this.montoSiniestro = montoSiniestro;
	}
	
	@XmlElement(name="rutBeneficiario")
	public String getRutBeneficiario() {
		return rutBeneficiario;
	}
	public void setRutBeneficiario(String rutBeneficiario) {
		this.rutBeneficiario = rutBeneficiario;
	}
	
	@XmlElement(name="nombreBeneficiario")
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}

}
