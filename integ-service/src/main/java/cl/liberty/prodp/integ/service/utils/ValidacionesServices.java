package cl.liberty.prodp.integ.service.utils;

import java.util.List;

import cl.liberty.prodp.integ.commons.responses.ErrorResponse;


public class ValidacionesServices {

	private ValidacionesServices() {
		
	}
	
	
	public static ErrorResponse validarListError(List<ErrorResponse> listErr) {
		
		ErrorResponse err = new ErrorResponse();
		
		if (!listErr.isEmpty()) {
			err = listErr.get(listErr.size() -1);
		} else {
			err = null;
		}

		return err;
	}
	
}
