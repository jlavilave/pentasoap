package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "detallePagoWeb")
public class DetallePagoWebPModel implements Serializable {

	private static final long serialVersionUID = -6121899401519609235L;

	private Long id;
	
	@NotNull(message="311046")
	@Min(value=1, message="311047")
	private Long numeroCorrelativo;

	@NotNull(message="311044")
	@Min(value=1, message="311045")
	private Long numeroReferencia;
	
	@NotNull(message="311074")
	@Min(value=0, message="311048")
	private Long cuota;
	
	@NotNull(message="311049")
	@Min(value=0, message="311050")
	private BigDecimal montoExento;
	
	@NotNull(message="311051")
	@Min(value=0, message="311052")
	private BigDecimal montoAfecto;
	
	@NotNull(message="311053")
	@Min(value=0, message="311054")
	private BigDecimal montoIva;
	
	@NotNull(message="311055")
	@Min(value=1, message="311056")
	private BigDecimal montoTotalOperacion;
	
	@Min(value=1, message="311057")
	private Long idPoliza;
	
	@Min(value=1, message="311058")
	private Long idEndoso;
	
	@Min(value=1, message="311059")
	private Long idCertificado;
	
	@Size(max = 20, message = "311060")
	private String rutPropietario;
	
	@Size(max = 100, message = "311061")
	private String nombrePropietario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="numeroCorrelativo")
	public Long getNumeroCorrelativo() {
		return numeroCorrelativo;
	}

	public void setNumeroCorrelativo(Long numeroCorrelativo) {
		this.numeroCorrelativo = numeroCorrelativo;
	}

	@XmlElement(name="numeroReferencia")
	public Long getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(Long numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	@XmlElement(name="cuota")
	public Long getCuota() {
		return cuota;
	}

	public void setCuota(Long cuota) {
		this.cuota = cuota;
	}

	@XmlElement(name="montoExento")
	public BigDecimal getMontoExento() {
		return montoExento;
	}

	public void setMontoExento(BigDecimal montoExento) {
		this.montoExento = montoExento;
	}

	@XmlElement(name="montoAfecto")
	public BigDecimal getMontoAfecto() {
		return montoAfecto;
	}

	public void setMontoAfecto(BigDecimal montoAfecto) {
		this.montoAfecto = montoAfecto;
	}

	@XmlElement(name="montoIva")
	public BigDecimal getMontoIva() {
		return montoIva;
	}

	public void setMontoIva(BigDecimal montoIva) {
		this.montoIva = montoIva;
	}

	@XmlElement(name="montoTotalOperacion")
	public BigDecimal getMontoTotalOperacion() {
		return montoTotalOperacion;
	}

	public void setMontoTotalOperacion(BigDecimal montoTotalOperacion) {
		this.montoTotalOperacion = montoTotalOperacion;
	}

	@XmlElement(name="idPoliza")
	public Long getIdPoliza() {
		return idPoliza;
	}

	public void setIdPoliza(Long idPoliza) {
		this.idPoliza = idPoliza;
	}

	@XmlElement(name="idEndoso")
	public Long getIdEndoso() {
		return idEndoso;
	}

	public void setIdEndoso(Long idEndoso) {
		this.idEndoso = idEndoso;
	}

	@XmlElement(name="idCertificado")
	public Long getIdCertificado() {
		return idCertificado;
	}

	public void setIdCertificado(Long idCertificado) {
		this.idCertificado = idCertificado;
	}

	@XmlElement(name="rutPropietario")
	public String getRutPropietario() {
		return rutPropietario;
	}

	public void setRutPropietario(String rutPropietario) {
		this.rutPropietario = rutPropietario;
	}

	@XmlElement(name="nombrePropietario")
	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}
}
