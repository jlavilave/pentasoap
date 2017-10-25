package cl.liberty.prodp.integ.service.services.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.ComisionPModel;
import cl.liberty.prodp.integ.commons.responses.ComisionRegResponse;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.restclient.ComisionRestClient;
import cl.liberty.prodp.integ.service.services.ComisionService;
import cl.liberty.prodp.integ.service.utils.ValidacionesServices;
import cl.liberty.prodp.integ.service.validation.ValidationBusinessComision;
import cl.liberty.prodp.integ.service.validation.ValidatorIntegrity;

@Service("comisionService")
public class ComisionServiceImpl implements ComisionService {

	private static final Logger LOGGER = Logger.getLogger(ComisionServiceImpl.class);

	@Autowired(required=true)
	private ComisionRestClient comisionRestClient;
	
	@Autowired(required=true)
	private ValidatorIntegrity validatorIntegrity;
	
	@Autowired(required=true)
	private ValidationBusinessComision validationBusinessComision;
	
	
	@Override
	public ComisionRegResponse registrarComision(ComisionPModel comision)
			throws IntegSoapPentaExcepcion {
		
		ComisionRegResponse response = new ComisionRegResponse();
		ErrorResponse err = new ErrorResponse();
		List<ErrorResponse> listErr;
		
		try {			
			listErr = validatorIntegrity.validar(comision);
			if (listErr.isEmpty()) {
				listErr = validationBusinessComision.validar(comision);
				if (listErr.isEmpty()) {
					response = comisionRestClient.registrar(comision);	
				}
			}
			err = ValidacionesServices.validarListError(listErr);
		} catch (IntegSoapPentaExcepcion e) {
			err.setCodigo(e.getCodigoExcepcion());
			err.setMensaje(e.getGlosaExcepcion());
			LOGGER.error(ComisionServiceImpl.class.getSimpleName() + " : " + e, e);
		} catch (IOException e) {
			err.setCodigo(CodigosComunesEnum.ERROR_ARCHIVO_PROPERTIES.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(ComisionServiceImpl.class.getSimpleName() + " : " + e, e);
		}  catch (Exception e) {
			err.setCodigo(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(ComisionServiceImpl.class.getSimpleName() + " : " + e, e);
		} 
		
		if(err != null){
			response.setError(err);
		}
		return response;
	}

}
