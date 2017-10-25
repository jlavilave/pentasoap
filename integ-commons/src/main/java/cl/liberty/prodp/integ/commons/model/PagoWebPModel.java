package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "pagoWeb")
public class PagoWebPModel implements Serializable{

	private static final long serialVersionUID = 6805117260253650918L;

	private Long id;
	
	@NotNull(message="311003")
	@Size(min = 1, message = "311003")
	private String fechaAviso;
	
	@NotNull(message="311005")
	@Size(min = 1, max=3, message = "311006")
	private String monOrigen;
	
	@NotNull(message="311007")
	@Min(value=0, message="311008")
	private BigDecimal mTotalExento;
	
	@NotNull(message="311009")
	@Min(value=0, message="311010")
	private BigDecimal mTotalAfecto;
	
	@NotNull(message="311011")
	@Min(value=0, message="311012")
	private BigDecimal mTotalIva;
	
	@NotNull(message="311013")
	@Min(value=1, message="311014")
	private BigDecimal montoTotal;
	
	@NotNull(message="311015")
	@Min(value=0, message="311016")
	private Long sperson;
	
	@Min(value=0, message="311017")
	private Long numeroProceso;
	
	@NotNull(message="311018")
	@Min(value=0, message="311019")
	private Integer rutCliente;
	
	@NotNull(message="311020")
	@Size(min = 1, message = "311021")
	private String dvRutCliente;
	
	@NotNull(message="311022")
	@Size(min = 1, message = "311023")
	private String codSucursal;
	
	@NotNull(message="311024")
	@Min(value=1, message="311025")
	private Long idEmpresa;
	
	@NotNull(message="311026")
	@Size(min = 1, message = "311027")
	private String empresaPago;
	
	@NotNull(message="311028")
	@Min(value=1, message="311029")
	@Max(value=16, message="311029")
	private Integer formatoPago;
	
	@Min(value=1, message="311030")
	private Integer formatoWeb;
	
	@NotNull(message="311031")
	@Min(value=1, message="311032")
	private Integer codigoIngreso;
	
	@NotNull(message="311033")
	@Size(min = 1, max=4, message = "311034")
	private String codigoBanco;
	
	@NotNull(message="311035")
	@Size(min = 1, message = "311036")
	private String cuentaBancaria;
	
	@NotNull(message="311042")
	@Min(value=1, message="311043")
	private Integer tipoMovimiento;
	
	@NotNull(message="311037")
	private Integer origenPw;
	
	@NotNull(message="311038")
	@Size(min = 1, message = "311039")
	private String nombreUsuario;	
	
	private Integer tipoDocumento;
	
	@NotNull(message="311078")
	private DetallePagoWebPModel[] detalles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="fechaAviso")
	public String getFechaAviso() {
		return fechaAviso;
	}

	public void setFechaAviso(String fechaAviso) {
		this.fechaAviso = fechaAviso;
	}

	@XmlElement(name="monedaOrigen")
	public String getMonOrigen() {
		return monOrigen;
	}

	public void setMonOrigen(String monOrigen) {
		this.monOrigen = monOrigen;
	}

	@XmlElement(name="montoTotalExento")
	public BigDecimal getmTotalExento() {
		return mTotalExento;
	}

	public void setmTotalExento(BigDecimal mTotalExento) {
		this.mTotalExento = mTotalExento;
	}

	@XmlElement(name="montoTotalAfecto")
	public BigDecimal getmTotalAfecto() {
		return mTotalAfecto;
	}

	public void setmTotalAfecto(BigDecimal mTotalAfecto) {
		this.mTotalAfecto = mTotalAfecto;
	}

	@XmlElement(name="montoTotalIva")
	public BigDecimal getmTotalIva() {
		return mTotalIva;
	}

	public void setmTotalIva(BigDecimal mTotalIva) {
		this.mTotalIva = mTotalIva;
	}

	@XmlElement(name="montoTotal")
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	@XmlElement(name="sperson")
	public Long getSperson() {
		return sperson;
	}

	public void setSperson(Long sperson) {
		this.sperson = sperson;
	}

	@XmlElement(name="numeroProceso")
	public Long getNumeroProceso() {
		return numeroProceso;
	}

	public void setNumeroProceso(Long numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	@XmlElement(name="rutCliente")
	public Integer getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(Integer rutCliente) {
		this.rutCliente = rutCliente;
	}

	@XmlElement(name="dvRutCliente")
	public String getDvRutCliente() {
		return dvRutCliente;
	}

	public void setDvRutCliente(String dvRutCliente) {
		this.dvRutCliente = dvRutCliente;
	}

	@XmlElement(name="codigoSucursal")
	public String getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}

	@XmlElement(name="idEmpresa")
	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@XmlElement(name="empresaPago")
	public String getEmpresaPago() {
		return empresaPago;
	}

	public void setEmpresaPago(String empresaPago) {
		this.empresaPago = empresaPago;
	}

	@XmlElement(name="formatoPago")
	public Integer getFormatoPago() {
		return formatoPago;
	}

	public void setFormatoPago(Integer formatoPago) {
		this.formatoPago = formatoPago;
	}

	@XmlElement(name="formatoWeb")
	public Integer getFormatoWeb() {
		return formatoWeb;
	}

	public void setFormatoWeb(Integer formatoWeb) {
		this.formatoWeb = formatoWeb;
	}

	@XmlElement(name="codigoIngreso")
	public Integer getCodigoIngreso() {
		return codigoIngreso;
	}

	public void setCodigoIngreso(Integer codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}

	@XmlElement(name="codigoBanco")
	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	@XmlElement(name="cuentaBancaria")
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	@XmlElement(name="codigoOrigen")
	public Integer getOrigenPw() {
		return origenPw;
	}

	public void setOrigenPw(Integer origenPw) {
		this.origenPw = origenPw;
	}

	@XmlElement(name="nombreUsuario")
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@XmlElementWrapper(name="detalles")
	@XmlElement(name="detalle")
	public DetallePagoWebPModel[] getDetalles() {
		return Arrays.copyOf(detalles, detalles.length);
	}

	public void setDetalles(DetallePagoWebPModel[] detalles) {
		this.detalles = Arrays.copyOf(detalles, detalles.length);
	}

	@XmlElement(name="tipoMovimiento")
	public Integer getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(Integer tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	@XmlElement(name="tipoDocumento")
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
}
