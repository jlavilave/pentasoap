package cl.liberty.prodp.integ.service.services.impl;

import java.io.IOException;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.ParamConsultaChequePModel;
import cl.liberty.prodp.integ.commons.responses.ConsultaChequeResponse;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.restclient.ChequeRestClient;
import cl.liberty.prodp.integ.service.services.ChequeService;
import cl.liberty.prodp.integ.service.utils.ValidacionesServices;
import cl.liberty.prodp.integ.service.validation.ValidatorBusinessCheque;
import cl.liberty.prodp.integ.service.validation.ValidatorIntegrity;

@Service("chequeService")
public class ChequeServiceImpl implements ChequeService {
	
	private static final Logger LOGGER = Logger.getLogger(ChequeServiceImpl.class);

	@Autowired(required=true)
	private ChequeRestClient chequeRestClient;
	
	@Autowired(required=true)
	private ValidatorIntegrity validatorIntegrity;
	
	@Autowired(required=true)
	private ValidatorBusinessCheque validatorBusinessCheque;
	
	@Override
	public ConsultaChequeResponse obtenerCheque(ParamConsultaChequePModel param)
			throws IntegSoapPentaExcepcion {
		
		ConsultaChequeResponse response = new ConsultaChequeResponse();
		ErrorResponse err = new ErrorResponse();
		List<ErrorResponse> listErr;
		
		try {
			listErr = validatorIntegrity.validar(param);
			if (listErr.isEmpty()) {
				listErr = validatorBusinessCheque.validar(param);
				if (listErr.isEmpty()) {
					response = chequeRestClient.obtener(param);
				}
			}
			err = ValidacionesServices.validarListError(listErr);
		} catch (IntegSoapPentaExcepcion e) {
			err.setCodigo(e.getCodigoExcepcion());
			err.setMensaje(e.getGlosaExcepcion());
			LOGGER.error(ChequeServiceImpl.class.getSimpleName() + " : " + e, e);
		} catch (IOException e) {
			err.setCodigo(CodigosComunesEnum.ERROR_ARCHIVO_PROPERTIES.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(ChequeServiceImpl.class.getSimpleName() + " : " + e, e);
		}  catch (Exception e) {
			err.setCodigo(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(ChequeServiceImpl.class.getSimpleName() + " : " + e, e);
		} 
		if(err != null){
			response.setError(err);
		}
		return response;
	}

}
