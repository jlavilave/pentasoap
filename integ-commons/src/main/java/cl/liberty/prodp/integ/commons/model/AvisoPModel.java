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


@XmlRootElement(name = "aviso")
public class AvisoPModel implements Serializable{

	private static final long serialVersionUID = 4572504785463763971L;
	
	private Long id;
	
	@NotNull(message="111003")
	@Min(value=1, message="111004")
	private BigDecimal mTotalRendicion;
	
	@NotNull(message="111005")
	@Min(value=0, message="111006")
	private BigDecimal mTotalAfecto;
	
	@NotNull(message="111007")
	@Min(value=0, message="111008")
	private BigDecimal mTotalExento;
	
	@NotNull(message="111009")
	@Min(value=0, message="111010")
	private BigDecimal mTotalIva;
	
	@NotNull(message="111011")
	@Min(value=0, message="111012")
	private BigDecimal otrosGastos;
	
	@NotNull(message="111013")
	@Min(value=1, message="111013")
	private Integer origen;
	
	@NotNull(message="111014")
	private Integer tipoMov;
	
	@NotNull(message="111015")
	@Size(min = 1, message = "111015")
	private String fechaVencimiento;
	
	@NotNull(message="111016")
	@Size(max=3, min=1, message="111017")
	private String monOrigen;
	
	private Long sperson;
	
	@Size(max = 75, message = "111018")
	private String nombre;
	
	@Size(max = 75, message = "111019")
	private String direccion;
	
	@Size(max = 75, message = "111020")
	private String comuna;
	
	@Size(max = 75, message = "111021")
	private String ciudad;
	
	@NotNull(message="111043")
	@Size(min=1, message="111042")
	private String nombreUsuario;

	@NotNull(message="111044")
	private DetalleAvisoPModel[] detalles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="montoTotalRendicion")
	public BigDecimal getmTotalRendicion() {
		return mTotalRendicion;
	}

	public void setmTotalRendicion(BigDecimal mTotalRendicion) {
		this.mTotalRendicion = mTotalRendicion;
	}

	@XmlElement(name="montoTotalAfecto")
	public BigDecimal getmTotalAfecto() {
		return mTotalAfecto;
	}

	public void setmTotalAfecto(BigDecimal mTotalAfecto) {
		this.mTotalAfecto = mTotalAfecto;
	}

	@XmlElement(name="montoTotalExento")
	public BigDecimal getmTotalExento() {
		return mTotalExento;
	}

	public void setmTotalExento(BigDecimal mTotalExento) {
		this.mTotalExento = mTotalExento;
	}

	@XmlElement(name="montoTotalIva")
	public BigDecimal getmTotalIva() {
		return mTotalIva;
	}

	public void setmTotalIva(BigDecimal mTotalIva) {
		this.mTotalIva = mTotalIva;
	}

	@XmlElement(name="otrosGastos")
	public BigDecimal getOtrosGastos() {
		return otrosGastos;
	}

	public void setOtrosGastos(BigDecimal otrosGastos) {
		this.otrosGastos = otrosGastos;
	}

	@XmlElement(name="codigoOrigen")
	public Integer getOrigen() {
		return origen;
	}

	public void setOrigen(Integer origen) {
		this.origen = origen;
	}

	@XmlElement(name="tipoMovimiento")
	public Integer getTipoMov() {
		return tipoMov;
	}

	public void setTipoMov(Integer tipoMov) {
		this.tipoMov = tipoMov;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	@XmlElement(name="fechaVencimiento")
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@XmlElement(name="monedaOrigen")
	public String getMonOrigen() {
		return monOrigen;
	}

	public void setMonOrigen(String monOrigen) {
		this.monOrigen = monOrigen;
	}

	@XmlElement(name="sperson")
	public Long getSperson() {
		return sperson;
	}

	public void setSperson(Long sperson) {
		this.sperson = sperson;
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="direccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@XmlElement(name="comuna")
	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	@XmlElement(name="ciudad")
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@XmlElementWrapper(name="detalles")
	@XmlElement(name="detalle")
	public DetalleAvisoPModel[] getDetalles() {
		return Arrays.copyOf(detalles, detalles.length);
	}

	public void setDetalles(DetalleAvisoPModel[] detalles) {
		this.detalles = Arrays.copyOf(detalles, detalles.length);
	}

	@XmlElement(name="nombreUsuario")
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
