package cl.liberty.prodp.integ.service.validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.utils.Propiedades;

@Component("validatorIntegrity")
public class ValidatorIntegrity{

	private Map<String, String> mapMsgs = new HashMap<String, String>();
	
	@Autowired(required=true)
	private Propiedades msgValid;
	
	public ValidatorIntegrity(){
		this.settingMapMsgs();
	}
	
	public <T> List<ErrorResponse> validar(T o, String... params) throws IOException{
			
		ErrorResponse errResponse;
		List<ErrorResponse> listErrores = new ArrayList<ErrorResponse>();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<T>> violations = validator.validate(o);
		
		//Para asegurarme que el listado se encuentra vacío
		listErrores.clear();
		if(violations != null && !violations.isEmpty()){
			Iterator z = violations.iterator();
			while (z.hasNext()){
				ConstraintViolation error = (ConstraintViolation)z.next();
				errResponse = new ErrorResponse();
				
				errResponse.setCodigo(error.getMessage());
				errResponse.setMensaje(msgValid.getProperty(mapMsgs.get(error.getMessage()),params));

				listErrores.add(errResponse);
			}
		}
		
		return listErrores;
	}
	
	public <T> List<ErrorResponse> validarListado(T[] list) throws IOException{
		
		List<ErrorResponse> listErr = new ArrayList<ErrorResponse>();
		for (T t : list) {
			listErr.addAll(this.validar(t));
		}
		return listErr;
	}
	
	public <T> void validarListadoVacio(T[] list, List<ErrorResponse> listErr, CodigosValidacionesEnum e) throws IOException {
		
		if(list.length == 0){
			listErr.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}
	}
	
	
	private void settingMapMsgs(){
		
		for (CodigosValidacionesEnum cods : CodigosValidacionesEnum.values()) {
			mapMsgs.put(cods.getCodigo(), cods.getNombreProperty());
		}
		
	}

	
}
