package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "solicitudPago")
public class SolicitudPagoPModel implements Serializable{

	private static final long serialVersionUID = 7468682912937909184L;

	private Long id;

	private Integer periodo;
	
	@NotNull(message="211005")
	@Min(value=1, message="211006")
	private Long numSiniestro;
	
	@NotNull(message="211008")
	@Min(value=1, message="211009")
	private Long numLiquidacion;
	
	@NotNull(message="211010")
	private String fechaPago;
	
	private String fechaTipoCambio;
	
	@NotNull(message="211011")
	@Size(max = 80, min=1, message = "211012")
	private String nombreBeneficiario;
	
	@NotNull(message="211015")
	@Size(max = 15, min=1, message = "211016")
	private String rutBeneficiario;
	
	@NotNull(message="211063")
	@Min(value=1, message="211063")
	private Integer monedaPago;
	
	@NotNull(message="211064")
	private String fechaProceso;
	
	private String fechaTraspaso;
	
	@NotNull(message="211065")
	@Size(max = 1, message = "211066")
	private String estado;
	
	@NotNull(message="211018")
	@Min(value=1, message="211019")
	private BigDecimal montoTotalNeto;
	
	@NotNull(message="211020")
	private BigDecimal montoTotalImpuesto;
	
	@Size(max = 3, message = "211069")
	private String formaPago;
		
	@NotNull(message="211067")
	private Integer origenSp;
	
	@NotNull(message="211021")
	@Size(min=1, message="211070")
	private String nombreUsuario;
	
	private Integer tipoDocumento;
	
	@NotNull(message="211068")
	private DocTributariosPModel[] documentos;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@XmlElement(name="periodo")
	public Integer getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	@XmlElement(name="numeroSiniestro")
	public Long getNumSiniestro() {
		return numSiniestro;
	}


	public void setNumSiniestro(Long numSiniestro) {
		this.numSiniestro = numSiniestro;
	}

	@XmlElement(name="numeroLiquidacion")
	public Long getNumLiquidacion() {
		return numLiquidacion;
	}


	public void setNumLiquidacion(Long numLiquidacion) {
		this.numLiquidacion = numLiquidacion;
	}

	@XmlElement(name="fechaPago")
	public String getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	@XmlElement(name="fechaTipoCambio")
	public String getFechaTipoCambio() {
		return fechaTipoCambio;
	}


	public void setFechaTipoCambio(String fechaTipoCambio) {
		this.fechaTipoCambio = fechaTipoCambio;
	}

	@XmlElement(name="nombreBeneficiario")
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}


	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}

	@XmlElement(name="rutBeneficiario")
	public String getRutBeneficiario() {
		return rutBeneficiario;
	}


	public void setRutBeneficiario(String rutBeneficiario) {
		this.rutBeneficiario = rutBeneficiario;
	}

	@XmlElement(name="monedaPago")
	public Integer getMonedaPago() {
		return monedaPago;
	}


	public void setMonedaPago(Integer monedaPago) {
		this.monedaPago = monedaPago;
	}

	@XmlElement(name="fechaProceso")
	public String getFechaProceso() {
		return fechaProceso;
	}


	public void setFechaProceso(String fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	@XmlElement(name="fechaTraspaso")
	public String getFechaTraspaso() {
		return fechaTraspaso;
	}


	public void setFechaTraspaso(String fechaTraspaso) {
		this.fechaTraspaso = fechaTraspaso;
	}

	@XmlElement(name="estado")
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	@XmlElement(name="montoTotalNeto")
	public BigDecimal getMontoTotalNeto() {
		return montoTotalNeto;
	}


	public void setMontoTotalNeto(BigDecimal montoTotalNeto) {
		this.montoTotalNeto = montoTotalNeto;
	}

	@XmlElement(name="montoTotalImpuesto")
	public BigDecimal getMontoTotalImpuesto() {
		return montoTotalImpuesto;
	}


	public void setMontoTotalImpuesto(BigDecimal montoTotalImpuesto) {
		this.montoTotalImpuesto = montoTotalImpuesto;
	}

	@XmlElement(name="formaPago")
	public String getFormaPago() {
		return formaPago;
	}


	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	@XmlElement(name="codigoOrigen")
	public Integer getOrigenSp() {
		return origenSp;
	}


	public void setOrigenSp(Integer origenSp) {
		this.origenSp = origenSp;
	}

	@XmlElement(name="nombreUsuario")
	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public void setDocumentos(DocTributariosPModel[] documentos) {
		this.documentos = Arrays.copyOf(documentos, documentos.length);
	}

	@XmlElementWrapper(name="documentos")
	@XmlElement(name="documento")
	public DocTributariosPModel[] getDocumentos() {
		return Arrays.copyOf(documentos, documentos.length);
	}

	@XmlElement(name="tipoDocumento")
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	

}
