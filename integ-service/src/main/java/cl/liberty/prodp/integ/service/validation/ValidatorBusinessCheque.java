package cl.liberty.prodp.integ.service.validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.model.ParamConsultaChequePModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;

@Component("validatorBusinessCheque")
public class ValidatorBusinessCheque extends PentaValidatorBusiness {
	
	public List<ErrorResponse> validar(ParamConsultaChequePModel param) throws IOException{
		
		List<ErrorResponse> listErr = new ArrayList<ErrorResponse>();
		
		if(param.getTipoDocumento() != null && param.getTipoDocumento() == TIPO_DOC_RUT){
			super.validarRut(param.getRutBeneficiario(), 
					listErr, CodigosValidacionesEnum.FORMATO_RUT_BENEF_CHK);
		}
		return listErr;
	}

}
