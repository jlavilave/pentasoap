package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "detalle")
public class DetalleAvisoPModel implements Serializable{

	private static final long serialVersionUID = -4929108201639068514L;
	
	private Long id;
	
	private Long idAviso;
	
	@NotNull(message="111030")
	@Min(value=1, message="111031")
	private Long nReferencia;
	
	@NotNull(message="111022")
	@Min(value=1, message="111023")
	private BigDecimal mRendicion;
	
	@NotNull(message="111024")
	@Min(value=0, message="111025")
	private BigDecimal mAfecto;
	
	@NotNull(message="111026")
	@Min(value=0, message="111027")
	private BigDecimal mExento;
	
	@NotNull(message="111028")
	@Min(value=0, message="111029")
	private BigDecimal mIva;
	
	private String sucursal;
	
	private Long nCuota;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="numeroReferencia")
	public Long getnReferencia() {
		return nReferencia;
	}

	public void setnReferencia(Long nReferencia) {
		this.nReferencia = nReferencia;
	}

	public Long getIdAviso() {
		return idAviso;
	}

	public void setIdAviso(Long idAviso) {
		this.idAviso = idAviso;
	}

	@XmlElement(name="montoRendicion")
	public BigDecimal getmRendicion() {
		return mRendicion;
	}

	public void setmRendicion(BigDecimal mRendicion) {
		this.mRendicion = mRendicion;
	}

	@XmlElement(name="montoAfecto")
	public BigDecimal getmAfecto() {
		return mAfecto;
	}

	public void setmAfecto(BigDecimal mAfecto) {
		this.mAfecto = mAfecto;
	}

	@XmlElement(name="montoExento")
	public BigDecimal getmExento() {
		return mExento;
	}

	public void setmExento(BigDecimal mExento) {
		this.mExento = mExento;
	}

	@XmlElement(name="montoIva")
	public BigDecimal getmIva() {
		return mIva;
	}

	public void setmIva(BigDecimal mIva) {
		this.mIva = mIva;
	}

	@XmlElement(name="codigoSucursal")
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	@XmlElement(name="numeroCuota")
	public Long getnCuota() {
		return nCuota;
	}

	public void setnCuota(Long nCuota) {
		this.nCuota = nCuota;
	}

}
