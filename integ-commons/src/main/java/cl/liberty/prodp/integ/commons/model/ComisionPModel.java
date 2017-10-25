package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "comision")
public class ComisionPModel implements Serializable{

	private static final long serialVersionUID = 176191884707775562L;

	private Long id;
	
	@NotNull(message="411001")
	@Size(max=15, min=1, message="411002")
	private String rutCorredor;
	
	@NotNull(message="411003")
	@Size(min=1, message="411003")
	private String codCorredorLiberty;
	
	@NotNull(message="411004")
	@Min(value=1900, message="411005")
	@Max(value=2100, message="411005")
	private Integer ano;
	
	@NotNull(message="411006")
	@Min(value=1, message="411008")
	@Max(value=12, message="411008")
	private Integer mes;
	
	@NotNull(message="411007")
	@Min(value=1, message="411037")
	@Max(value=2, message="411037")
	private Integer quincena;
	
	@NotNull(message="411011")
	@Min(value=1, message="411010")
	@Max(value=999, message="411010")
	private Integer conceptoPago;
	
	@NotNull(message="411009")
	@Min(value=1, message="411039")
	@Max(value=2, message="411039")
	private Integer debeHaber;
	
	@NotNull(message="411013")
	@Size(max=3, min=1, message="411012")
	private String monedaPago;
	
	@NotNull(message="411015")
	private String fechaMovimiento;
	
	@NotNull(message="411016")
	@Min(value=0, message="411038")
	@Max(value=1, message="411038")
	private Integer tipoOperacion;
	
	@NotNull(message="411018")
	@Min(value=0, message="411017")
	private BigDecimal montoAfecto;
	
	@NotNull(message="411020")
	@Min(value=0, message="411019")
	private BigDecimal montoExento;
	
	@NotNull(message="411022")
	@Min(value=0, message="411021")
	private BigDecimal montoIva;
	
	@NotNull(message="411024")
	@DecimalMin(value="0.0001", message="411023")
	private BigDecimal montoTotal;
	
	@NotNull(message="411025")
	private Integer poliza;
	
	@NotNull(message="411026")
	private Integer certificado;
	
	@NotNull(message="411027")
	private Integer endoso;
	
	@NotNull(message="411028")	
	private Integer origenCom;
	
	@NotNull(message="411029")
	@Size(max=20, min=1, message="411030")
	private String nombreUsuario;
	
	@NotNull(message="411032")
	@Size(max=100, min=1, message="411031")
	private String descripcionMov;
	
	@NotNull(message="411033")
	@Min(value=1, message="411033")
	private Long empresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="rutCorredor")
	public String getRutCorredor() {
		return rutCorredor;
	}

	public void setRutCorredor(String rutCorredor) {
		this.rutCorredor = rutCorredor;
	}

	@XmlElement(name="codigoCorredorLiberty")
	public String getCodCorredorLiberty() {
		return codCorredorLiberty;
	}

	public void setCodCorredorLiberty(String codCorredorLiberty) {
		this.codCorredorLiberty = codCorredorLiberty;
	}

	@XmlElement(name="anio")
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@XmlElement(name="mes")
	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	@XmlElement(name="quincena")
	public Integer getQuincena() {
		return quincena;
	}

	public void setQuincena(Integer quincena) {
		this.quincena = quincena;
	}

	@XmlElement(name="conceptoPago")
	public Integer getConceptoPago() {
		return conceptoPago;
	}

	public void setConceptoPago(Integer conceptoPago) {
		this.conceptoPago = conceptoPago;
	}

	@XmlElement(name="debeHaber")
	public Integer getDebeHaber() {
		return debeHaber;
	}

	public void setDebeHaber(Integer debeHaber) {
		this.debeHaber = debeHaber;
	}

	@XmlElement(name="monedaPago")
	public String getMonedaPago() {
		return monedaPago;
	}

	public void setMonedaPago(String monedaPago) {
		this.monedaPago = monedaPago;
	}

	@XmlElement(name="fechaMovimiento")
	public String getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	@XmlElement(name="tipoOperacion")
	public Integer getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(Integer tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	@XmlElement(name="montoAfecto")
	public BigDecimal getMontoAfecto() {
		return montoAfecto;
	}

	public void setMontoAfecto(BigDecimal montoAfecto) {
		this.montoAfecto = montoAfecto;
	}

	@XmlElement(name="montoExento")
	public BigDecimal getMontoExento() {
		return montoExento;
	}

	public void setMontoExento(BigDecimal montoExento) {
		this.montoExento = montoExento;
	}

	@XmlElement(name="montoIva")
	public BigDecimal getMontoIva() {
		return montoIva;
	}

	public void setMontoIva(BigDecimal montoIva) {
		this.montoIva = montoIva;
	}

	@XmlElement(name="montoTotal")
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	@XmlElement(name="poliza")
	public Integer getPoliza() {
		return poliza;
	}

	public void setPoliza(Integer poliza) {
		this.poliza = poliza;
	}

	@XmlElement(name="certificado")
	public Integer getCertificado() {
		return certificado;
	}

	public void setCertificado(Integer certificado) {
		this.certificado = certificado;
	}

	@XmlElement(name="endoso")
	public Integer getEndoso() {
		return endoso;
	}

	public void setEndoso(Integer endoso) {
		this.endoso = endoso;
	}

	@XmlElement(name="codigoOrigen", nillable=true)
	public Integer getOrigenCom() {
		return origenCom;
	}

	public void setOrigenCom(Integer origenCom) {
		this.origenCom = origenCom;
	}

	@XmlElement(name="nombreUsuario")
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@XmlElement(name="descripcionMovimiento")
	public String getDescripcionMov() {
		return descripcionMov;
	}

	public void setDescripcionMov(String descripcionMov) {
		this.descripcionMov = descripcionMov;
	}

	@XmlElement(name="empresa")
	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long empresa) {
		this.empresa = empresa;
	}
	
}
