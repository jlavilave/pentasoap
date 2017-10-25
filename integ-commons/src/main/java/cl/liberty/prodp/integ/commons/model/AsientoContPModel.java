package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "asientoContable")
public class AsientoContPModel implements Serializable {

	private static final long serialVersionUID = 6155429904158727770L;
	
	@NotNull(message="511007")
	@Min(value=1, message="511008")
	private Long numeroAsiento;
	
	@NotNull(message="511015")
	@Size(max=240, message="511038")
	private String nombreAsiento;
	
	@Size(max=240, message="511039")
	private String descLineaAsiento;
	
	@NotNull(message="511016")
	@Size(max=25, message="511040")
	private String codigoCompania;
	
	@NotNull(message="511017")
	@Size(max=25, message="511041")
	private String codigoCuenta;
	
	@NotNull(message="511018")
	@Size(max=25, message="511042")
	private String centroResponsabilidad; 
	
	@NotNull(message="511019")
	@Size(max=25, message="511043")
	private String ramo;
	
	@NotNull(message="511020")
	@Size(max=25, message="511044")
	private String lineaNegocio;
	
	@Size(max=25, message="511045")
	private String concepto;
	
	@Size(max=25, message="511046")
	private String segmentoF1;
	
	@Size(max=25, message="511047")
	private String segmentoF2;
	
	@Size(max=25, message="511048")
	private String segmentoF3;
	
	@Size(max=25, message="511049")
	private String segmentoF4;
	
	@NotNull(message="511021")
	@Min(value=0, message="511022")
	private BigDecimal montoDebe;
	
	@NotNull(message="511023")
	@Min(value=0, message="511024")
	private BigDecimal montoHaber;
	
	
	@XmlElement(name="numeroAsiento")
	public Long getNumeroAsiento() {
		return numeroAsiento;
	}

	public void setNumeroAsiento(Long numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}

	@XmlElement(name="nombreAsiento")
	public String getNombreAsiento() {
		return nombreAsiento;
	}

	public void setNombreAsiento(String nombreAsiento) {
		this.nombreAsiento = nombreAsiento;
	}

	@XmlElement(name="descLineaAsiento")
	public String getDescLineaAsiento() {
		return descLineaAsiento;
	}

	public void setDescLineaAsiento(String descLineaAsiento) {
		this.descLineaAsiento = descLineaAsiento;
	}

	@XmlElement(name="codigoCompania")
	public String getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	@XmlElement(name="codigoCuenta")
	public String getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	@XmlElement(name="centroResponsabilidad")
	public String getCentroResponsabilidad() {
		return centroResponsabilidad;
	}

	public void setCentroResponsabilidad(String centroResponsabilidad) {
		this.centroResponsabilidad = centroResponsabilidad;
	}

	@XmlElement(name="ramo")
	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	@XmlElement(name="lineaNegocio")
	public String getLineaNegocio() {
		return lineaNegocio;
	}

	public void setLineaNegocio(String lineaNegocio) {
		this.lineaNegocio = lineaNegocio;
	}

	@XmlElement(name="concepto")
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@XmlElement(name="segmentoF1")
	public String getSegmentoF1() {
		return segmentoF1;
	}

	public void setSegmentoF1(String segmentoF1) {
		this.segmentoF1 = segmentoF1;
	}

	@XmlElement(name="segmentoF2")
	public String getSegmentoF2() {
		return segmentoF2;
	}

	public void setSegmentoF2(String segmentoF2) {
		this.segmentoF2 = segmentoF2;
	}

	@XmlElement(name="segmentoF3")
	public String getSegmentoF3() {
		return segmentoF3;
	}

	public void setSegmentoF3(String segmentoF3) {
		this.segmentoF3 = segmentoF3;
	}

	@XmlElement(name="segmentoF4")
	public String getSegmentoF4() {
		return segmentoF4;
	}

	public void setSegmentoF4(String segmentoF4) {
		this.segmentoF4 = segmentoF4;
	}

	@XmlElement(name="montoDebe")
	public BigDecimal getMontoDebe() {
		return montoDebe;
	}

	public void setMontoDebe(BigDecimal montoDebe) {
		this.montoDebe = montoDebe;
	}

	@XmlElement(name="montoHaber")
	public BigDecimal getMontoHaber() {
		return montoHaber;
	}

	public void setMontoHaber(BigDecimal montoHaber) {
		this.montoHaber = montoHaber;
	}
	
	
}
