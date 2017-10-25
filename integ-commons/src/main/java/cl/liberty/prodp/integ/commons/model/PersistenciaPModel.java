package cl.liberty.prodp.integ.commons.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class PersistenciaPModel implements Serializable{

	private static final long serialVersionUID = -5363780597269824368L;

	private Long id;
	
	private Timestamp fechaRegistro;
	
	private String nombreUsuario;
	
	private Integer origen;
	
	private String llaveRegistro;
	
	private String tipoSist;
	
	private String nombreWs;
	
	private String nombreFuncionWs;
	
	private String objEntrada;
	
	private Integer respGral;
	
	private String errores;
	
	private String valoresDevueltos;
	
	private Timestamp fechaRespuesta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechaRegistro() {
		return new Timestamp(fechaRegistro.getTime());
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = new Timestamp(fechaRegistro.getTime());
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Integer getOrigen() {
		return origen;
	}

	public void setOrigen(Integer origen) {
		this.origen = origen;
	}

	public String getLlaveRegistro() {
		return llaveRegistro;
	}

	public void setLlaveRegistro(String llaveRegistro) {
		this.llaveRegistro = llaveRegistro;
	}

	public String getTipoSist() {
		return tipoSist;
	}

	public void setTipoSist(String tipoSist) {
		this.tipoSist = tipoSist;
	}

	public String getNombreWs() {
		return nombreWs;
	}

	public void setNombreWs(String nombreWs) {
		this.nombreWs = nombreWs;
	}

	public String getNombreFuncionWs() {
		return nombreFuncionWs;
	}

	public void setNombreFuncionWs(String nombreFuncionWs) {
		this.nombreFuncionWs = nombreFuncionWs;
	}

	public String getObjEntrada() {
		return objEntrada;
	}

	public void setObjEntrada(String objEntrada) {
		this.objEntrada = objEntrada;
	}

	public Integer getRespGral() {
		return respGral;
	}

	public void setRespGral(Integer respGral) {
		this.respGral = respGral;
	}

	public String getErrores() {
		return errores;
	}

	public void setErrores(String errores) {
		this.errores = errores;
	}

	public String getValoresDevueltos() {
		return valoresDevueltos;
	}

	public void setValoresDevueltos(String valoresDevueltos) {
		this.valoresDevueltos = valoresDevueltos;
	}

	public Timestamp getFechaRespuesta() {
		return new Timestamp(fechaRespuesta.getTime());
	}

	public void setFechaRespuesta(Timestamp fechaRespuesta) {
		this.fechaRespuesta = new Timestamp(fechaRespuesta.getTime());
	}
	
	

}
