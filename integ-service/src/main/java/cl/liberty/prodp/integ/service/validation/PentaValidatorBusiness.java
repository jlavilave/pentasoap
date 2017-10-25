package cl.liberty.prodp.integ.service.validation;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.model.DetalleAvisoPModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.utils.Propiedades;

public class PentaValidatorBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(PentaValidatorBusiness.class);
	
	protected static final String COD_MONEDA_CHILE = "CLP";
	
	protected static final String[] MONEDAS_VALIDAS = {"CLP", "UF" , "USD" , "EUR"};
	
	protected static final Integer TIPO_DOC_RUT = 4;
	
	@Autowired(required=true)
	private Propiedades msgValid;
	
	protected boolean validarRut(String rutInicial) {

		boolean validacion = false;
		try {
			validacion = validacionRut(rutInicial);

		} catch (java.lang.NumberFormatException e) {
			LOGGER.error(PentaValidatorBusiness.class.getSimpleName() + " : " + e, e);
		} catch (Exception e) {
			LOGGER.error(PentaValidatorBusiness.class.getSimpleName() + " : " + e, e);
		}
		return validacion;
	}
	
	
	protected void validarRut(String rutInicial, List<ErrorResponse> list, 
			CodigosValidacionesEnum e){
		
		boolean validacion = false;
		try {
			validacion = validacionRut(rutInicial);

			if(!validacion){
				list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
			}
		} catch (Exception ex) {
			LOGGER.error(PentaValidatorBusiness.class.getSimpleName() + " : " + ex, ex);
		}
	}
	
	private boolean validacionRut(String rutInicial){
		boolean validacion = false;
		
		String rut =  rutInicial.toUpperCase();
		rut = rut.replace(".", "");
		rut = rut.replace("-", "");
		int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
		char dv = rut.charAt(rut.length() - 1);
	
		int m = 0, s = 1;
		for (; rutAux != 0; rutAux /= 10) {
			s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
		}
		if (dv == (char) (s != 0 ? s + 47 : 75)) {
			validacion = true;
		}
		return validacion;
	}
	
	protected void comparar(BigDecimal montoA, BigDecimal montoB, 
			List<ErrorResponse> list, CodigosValidacionesEnum e) throws IOException{
		
		if(montoA.compareTo(montoB) != 0){
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}
	}
	
	protected void comparar(DetalleAvisoPModel det, BigDecimal montoB, 
			List<ErrorResponse> list, CodigosValidacionesEnum e) throws IOException{
		
		if(montoB.compareTo(det.getmRendicion()) != 0){
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty(), det.getnReferencia())));
		}
	}
	
	protected void indexOf(String[] cadena, String var, List<ErrorResponse> list, 
			CodigosValidacionesEnum e) throws IOException{
		
		List<String> listStr = Arrays.asList(cadena);
		if(!listStr.contains(var)){
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}
	}
	
	protected void comparar(String var, String[] ctes, String var2, String cte,
			List<ErrorResponse> list, CodigosValidacionesEnum e, String nDoc) throws IOException{
		
		
		List<String> listCtes = Arrays.asList(ctes);
		if(listCtes.contains(var) && !cte.equals(var2)){
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty(), nDoc)));
		}
	}
	
	protected void comparar(String cte1, String var1, String cte2, String var2, BigDecimal var3,
			List<ErrorResponse> list, CodigosValidacionesEnum e, String nDoc) throws IOException{

		if(cte1.equals(var1) && cte2.equals(var2) && BigDecimal.ZERO.compareTo(var3) != 0) {
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty(), nDoc)));
		}
	}
	
	protected void comparar(String cte1, String var1, String cte2, String var2, BigDecimal var3,
			List<ErrorResponse> list, CodigosValidacionesEnum e) throws IOException{

		if(cte1.equals(var1) && cte2.equals(var2) && BigDecimal.ZERO.compareTo(var3) != 0) {
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}
	}
	
	protected void comparar(String cte1, String var1, BigDecimal var3,
			List<ErrorResponse> list, CodigosValidacionesEnum e, String nDoc) throws IOException{

		if(cte1.equals(var1) && BigDecimal.ZERO.compareTo(var3) != 0) {
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty(),nDoc)));
		}
	}
	
	protected void validarRango(BigDecimal var, BigDecimal rangoInf, BigDecimal rangoSup,
			List<ErrorResponse> list, CodigosValidacionesEnum e) throws IOException{
		
		if(var.compareTo(rangoInf) == -1 || var.compareTo(rangoSup) == 1){
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}
	}
	
	protected void validarRango(BigDecimal var, BigDecimal rangoInf, BigDecimal rangoSup,
			List<ErrorResponse> list, CodigosValidacionesEnum e, String nDoc) throws IOException{
		
		if(var.compareTo(rangoInf) == -1 || var.compareTo(rangoSup) == 1){
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty(),nDoc)));
		}
	}

	protected BigDecimal sumarBigDecimal(BigDecimal valorPrincipal, BigDecimal var2){
		
		BigDecimal suma = BigDecimal.ZERO;
		
		if(valorPrincipal != null){
			if(var2 != null){
				suma = valorPrincipal.add(var2);
			}else{
				suma = valorPrincipal;
			}
		}

		return suma;
	}
	
	
	protected Boolean validarStringTimestamp(String fecha) throws IOException{
		
		Boolean resp = true;
		
		if(fecha.length() != 14){
			resp = false;
		}else {
			
			String fec = fecha.substring(0, 8);
			resp = validarStringDate(fec); 
			if(resp){
				
				String hh = fecha.substring(8, 10);
				String mm = fecha.substring(10, 12);
				String ss = fecha.substring(12, 14);
				
				Integer h = Integer.valueOf(hh);
				Integer m = Integer.valueOf(mm);
				Integer s = Integer.valueOf(ss);
				
				if (h < 0 || h > 24) {
					resp = false;
				}
				if (m < 0  || m > 59) {
					resp = false;
				}
				if (s < 0  || s > 59) {
					resp = false;
				}
			}
			
			
		}
		
		return resp;
	}
	
	protected Boolean validarStringDate(String fecha) throws IOException{
		
		Boolean resp = true;
		
		if(fecha.length() != 8){
			resp = false;
		}else {
		
			String annio = fecha.substring(0, 4);
			String mes = fecha.substring(4, 6);
			String dia = fecha.substring(6, 8);
			
			Integer a = Integer.valueOf(annio);
			Integer m = Integer.valueOf(mes);
			Integer d = Integer.valueOf(dia);
			
			if (a < 1900 || a > 2100) {
				resp = false;
			}
			if (m < 1 || m > 12) {
				resp = false;
			}
			if (d < 1 || d > 31) {
				resp = false;
			}
			
			if(!esBisiesto(fecha)){
				resp = false;
			}
		}

		return resp;
	}
	
	
	private Boolean esBisiesto(String fecha) throws IOException{
		Boolean resp = true;
		
		String annio = fecha.substring(0, 4);
		String mes = fecha.substring(4, 6);
		String dia = fecha.substring(6, 8);
		
		Integer a = Integer.valueOf(annio);
		Integer m = Integer.valueOf(mes);
		Integer d = Integer.valueOf(dia);
		
		if (m == 2 && (d == 30 || d == 31)) {
			resp = false;
		}
		if((a%4) != 0 && m == 2 && d == 29 ){
			resp = false;
		}
		
		return resp;
	}
	
	protected Boolean bigDecimalEsDecimal(BigDecimal valor){
		
		Boolean resp = false;
		BigDecimal result = valor.subtract(valor.setScale(0, RoundingMode.FLOOR)).movePointRight(valor.scale()); 
		
		if(result.compareTo(BigDecimal.ZERO) != 0){
			resp = true;
		}
		
		return resp;
	}
	
	
	protected void validarMonedaCLP(String str, List<ErrorResponse> list, CodigosValidacionesEnum e) throws IOException{
		
		if(!COD_MONEDA_CHILE.equals(str)){
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}
	}
	
	protected void validarFechaCorta(String fecha, List<ErrorResponse> listErr, CodigosValidacionesEnum e) throws IOException{
		
		if(!validarStringDate(fecha)){
			listErr.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}		
	}
	
}
