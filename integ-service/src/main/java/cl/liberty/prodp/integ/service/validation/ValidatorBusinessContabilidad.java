package cl.liberty.prodp.integ.service.validation;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.model.AsientoContPModel;
import cl.liberty.prodp.integ.commons.model.ComprobanteContPModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.utils.Propiedades;

@Component("validatorBusinessContabilidad")
public class ValidatorBusinessContabilidad extends PentaValidatorBusiness{
	
	public static final String[] CODIGOS_MONEDAS = {"CLP","UF"};
	
	public static final String CODIGO_CPL = "CLP";
	
	@Autowired(required=true)
	private Propiedades msgValid;
	
	public List<ErrorResponse> validar(ComprobanteContPModel c) throws IOException{
		
		List<ErrorResponse> listErr = new ArrayList<ErrorResponse>();
		
		if(!super.validarStringDate(c.getFechaContable())){
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.CONT_BUS_FECHA_CONTABLE.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.CONT_BUS_FECHA_CONTABLE.getNombreProperty())));
		}
		
		List<String> list = Arrays.asList(CODIGOS_MONEDAS);
		if(!list.contains(c.getCodigoMoneda())){
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.CONT_BUS_CODIGO_MONEDA.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.CONT_BUS_CODIGO_MONEDA.getNombreProperty())));
		}
			
		int debe = 0;
		int haber = 0;
		for (AsientoContPModel a : c.getAsientos()) {
			if(CODIGO_CPL.equals(c.getCodigoMoneda())){
				if (super.bigDecimalEsDecimal(a.getMontoDebe())) {
					listErr.add(new ErrorResponse(CodigosValidacionesEnum.CONT_BUS_CPL_DEFAULT_MONTODEBE.getCodigo(), 
							msgValid.getProperty(CodigosValidacionesEnum.CONT_BUS_CPL_DEFAULT_MONTODEBE.getNombreProperty(), a.getNumeroAsiento())));
				}
				if (super.bigDecimalEsDecimal(a.getMontoHaber())) {
					listErr.add(new ErrorResponse(CodigosValidacionesEnum.CONT_BUS_CPL_DEFAULT_MONTOHABER.getCodigo(), 
							msgValid.getProperty(CodigosValidacionesEnum.CONT_BUS_CPL_DEFAULT_MONTOHABER.getNombreProperty(), a.getNumeroAsiento())));
				}
			}
			
			debe = a.getMontoHaber().compareTo(BigDecimal.ZERO);
			haber = a.getMontoDebe().compareTo(BigDecimal.ZERO);
			
			if (debe == 1 && haber == 1){
				listErr.add(new ErrorResponse(CodigosValidacionesEnum.CONT_BUS_MONTO_DEBE_HABER_CERO.getCodigo(), 
						msgValid.getProperty(CodigosValidacionesEnum.CONT_BUS_MONTO_DEBE_HABER_CERO.getNombreProperty(), a.getNumeroAsiento())));
			}
		}
		
		return listErr;
	}

}
