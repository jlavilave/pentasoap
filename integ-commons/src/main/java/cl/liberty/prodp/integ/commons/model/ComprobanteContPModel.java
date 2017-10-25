package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "comprobanteContable")
public class ComprobanteContPModel implements Serializable{
	
	private static final long serialVersionUID = 3188474825478962808L;

	@NotNull(message="511001")
	@Min(value=1, message="511002")
	private Integer idEmpresa;
	
	@NotNull(message="511003")
	private String fechaContable;
	
	@Size(max=3, message="511035")
	private String codigoMoneda;
	
	@NotNull(message="511006")
	@Size(max=27, min=1, message="511036")
	private String nombreComprobante;
	
	@NotNull(message="511037")
	private AsientoContPModel[] asientos;

	@XmlElement(name="idEmpresa")
	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@XmlElement(name="fechaContable")
	public String getFechaContable() {
		return fechaContable;
	}

	public void setFechaContable(String fechaContable) {
		this.fechaContable = fechaContable;
	}

	@XmlElement(name="codigoMoneda")
	public String getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	
	@XmlElement(name="nombreComprobante")
	public String getNombreComprobante() {
		return nombreComprobante;
	}

	public void setNombreComprobante(String nombreComprobante) {
		this.nombreComprobante = nombreComprobante;
	}

	@XmlElementWrapper(name="asientosContables")
	@XmlElement(name="asientoContable")
	public AsientoContPModel[] getAsientos() {
		return Arrays.copyOf(asientos, asientos.length);
	}

	public void setAsientos(AsientoContPModel[] asientos) {
		this.asientos = Arrays.copyOf(asientos, asientos.length);
	}

}
